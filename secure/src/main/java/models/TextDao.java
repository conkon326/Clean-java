package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * bbs_db操作用DAO
 *
 * @author N.Fukuda
 */
public class TextDao {
  private Connection connection;

  /**
   * DBのオープン
   *
   * @throws ClassNotFoundException
   * @throws SQLException
   */
  public TextDao() throws ClassNotFoundException, SQLException {
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
   * text_tblの全件をArrayListに詰めて返す
   *
   * @return ArrayList<String>
   * @throws SQLException
   */
  public ArrayList<String> selText() throws SQLException {

    Statement stmt = connection.createStatement();
    ResultSet rs = null;
    ArrayList<String> list = null;
    try {
      String strSql = "SELECT * FROM text_tbl";

      rs = stmt.executeQuery(strSql);
      list = new ArrayList<String>();
      while(rs.next()){
        String s = rs.getString("text");
        list.add(s);
      }
      rs.close();

    } finally {
      stmt.close();
    }
    return list;
  }

  /**
   * 画面から入力された文字列をtext_tblにinsert
   *   (SQL文は文字列連結で生成)
   *
   * @return ArrayList<String>
   * @throws SQLException
   */
  public int insText1(String text) throws SQLException {
    Statement stmt = connection.createStatement();
    int count = 0;
    try {
      String strSql =
        "INSERT INTO text_tbl(text) VALUES('"+text+"')";
//確認用
System.out.println("SQL>"+strSql);

	      count = stmt.executeUpdate(strSql);
    } finally {
      stmt.close();
    }
    return count;
  }

  /**
   * 画面から入力された文字列をtext_tblにinsert
   *   (SQL文はプリペアードステートメントで生成)
   *
   * @return ArrayList<String>
   * @throws SQLException
   */
  public int insText2(String text) throws SQLException {
    PreparedStatement pstatement = null;
    int count = 0;
    try {
      pstatement = connection.prepareStatement(
        "INSERT INTO text_tbl(text) VALUES(?)");
      pstatement.setString(1, text);
      count = pstatement.executeUpdate();
    } finally {
      pstatement.close();
    }
    return count;
  }
}