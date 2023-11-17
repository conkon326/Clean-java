package daoPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoTest {
	private Connection connection;

	public DaoTest() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/sweets_database" +
						"?user=Mulder&password=TrustNo1" +
						"&useUnicode=true&characterEncoding=MS932");
	}

	public void close() {
		try {

			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//▼引数にid を受け取り、検索を行うメソッド
	public String[] getSweetsDataById(int id) throws SQLException {
		String[] empData = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			pstatement = connection.prepareStatement("SELECT * FROM product_tbl WHERE id = ?");
			pstatement.setInt(1, id);
			rs = pstatement.executeQuery();
			if (rs.next()) {
				empData = new String[3];
				empData[0] = rs.getString("id");
				empData[1] = rs.getString("name");
				empData[2] = rs.getString("price");
			}
			rs.close();
		} finally {
			pstatement.close();
		}
		return empData;
	}

	//	▼引数にpriceを受け取り、検索を行うメソッド
	public ArrayList<String[]> getSweetsDataByPrice(int from, int to) throws SQLException {
		ArrayList<String[]> empData = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;

		try {
			pstatement = connection.prepareStatement("SELECT * FROM product_tbl WHERE price BETWEEN ? AND ?");
			pstatement.setInt(1, from);
			pstatement.setInt(2, to);
			rs = pstatement.executeQuery();
			empData = new ArrayList<String[]>();

			while (rs.next()) {
				String[] emp = new String[3];
				emp[0] = rs.getString("id");
				emp[1] = rs.getString("name");
				emp[2] = rs.getString("price");
				empData.add(emp);
			}
			rs.close();
		} finally {
			pstatement.close();
		}
		return empData;
	}

}