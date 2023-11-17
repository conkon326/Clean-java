package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * bbs_db����pDAO
 *
 * @author N.Fukuda
 */
public class MemberDao {
  private Connection connection;

  /**
   * DB�̃I�[�v��
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
   * DB�̃N���[�Y
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
   * members_tbl���烆�[�U�[��/�p�X���[�h�����ɃZ���N�g
   *   (SQL���͕�����A���Ő���)
   *
   * @return String�w�o�^��/���o�^�x
   * @throws SQLException
   */
  public String checkMembers1(String name,String pass) throws SQLException {
    String check = "�����o�^�ł��I��";
    Statement stmt = connection.createStatement();
    ResultSet rs = null;
    try {
      String strSql = "SELECT * FROM members_tbl WHERE name='"
                      + name + "' and password='" + pass +"'";
//�m�F�p
System.out.println(strSql);

      rs = stmt.executeQuery(strSql);
      if(rs.next()) {
        check = "�o�^�σ����o�[�ł��B";
      }
      rs.close();

    } finally {
      stmt.close();
    }
    return check;
  }

  /**
   * members_tbl���烆�[�U�[��/�p�X���[�h�����ɃZ���N�g
   *   (SQL���̓v���y�A�[�h�X�e�[�g�����g�Ő���)
   *
   * @return String�w�o�^��/���o�^�x
   * @throws SQLException
   */
  public String checkMembers2(String name,String pass) throws SQLException {
    String check = "�����o�^�ł��I��";
    PreparedStatement pstatement = null;
    ResultSet rs = null;
    try {
      pstatement = connection.prepareStatement(
       "SELECT * FROM members_tbl WHERE name=? and password=?");
      pstatement.setString(1, name);
      pstatement.setString(2, pass);
      //���ӂ̂���SQL������͂���Ă��w�P���ȕ�����x�Ƃ���
      //�u�������Ă����̂Ť�e�����y�ڂ��Ȃ��

      rs = pstatement.executeQuery();
      if(rs.next()) {
        check = "�o�^�σ����o�[�ł��B";
      }
      rs.close();
    } finally {
      pstatement.close();
    }
    return check;
  }

}