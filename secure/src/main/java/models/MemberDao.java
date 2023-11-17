package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * bbs_db操作用DAO
 *
 * @author N.Fukuda
 */
public class MemberDao {
  private Connection connection;

  /**
   * DBのオープン
   *
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public MemberDao() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    connection = DriverManager.getConnection(
         "jdbc:mysql://localhost:3306/members_db"
       + "?user=root&password=admin"
       + "&useUnicode=true&characterEncoding=MS932");
  }

  /**
   * DBのクローズ
   */
  public void close() {
    try {
      if (connection != null) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * members_tblからユーザー名/パスワードを元にセレクト
   *   (SQL文は文字列連結で生成)
   *
   * @return String『登録済/未登録』
   * @throws SQLException
   */
  public String checkMembers1(String name,String pass) throws SQLException {
    String check = "※未登録です！※";
    Statement stmt = connection.createStatement();
    ResultSet rs = null;
    try {
      String strSql = "SELECT * FROM members_tbl WHERE name='"
                      + name + "' and password='" + pass +"'";
//確認用
System.out.println(strSql);

      rs = stmt.executeQuery(strSql);
      if(rs.next()) {
        check = "登録済メンバーです。";
      }
      rs.close();

    } finally {
      stmt.close();
    }
    return check;
  }

  /**
   * members_tblからユーザー名/パスワードを元にセレクト
   *   (SQL文はプリペアードステートメントで生成)
   *
   * @return String『登録済/未登録』
   * @throws SQLException
   */
  public String checkMembers2(String name,String pass) throws SQLException {
    String check = "※未登録です！※";
    PreparedStatement pstatement = null;
    ResultSet rs = null;
    try {
      pstatement = connection.prepareStatement(
       "SELECT * FROM members_tbl WHERE name=? and password=?");
      pstatement.setString(1, name);
      pstatement.setString(2, pass);
      //悪意のあるSQL文を入力されても『単純な文字列』として
      //置き換えてくれるので､影響を及ぼさない｡

      rs = pstatement.executeQuery();
      if(rs.next()) {
        check = "登録済メンバーです。";
      }
      rs.close();
    } finally {
      pstatement.close();
    }
    return check;
  }

}