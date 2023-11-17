package modelPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public ProductEntity getSweetsDataById(int id) throws SQLException {
		ProductEntity ent = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;

		try {
			pstatement = connection.prepareStatement("SELECT * FROM product_tbl WHERE id = ?");
			pstatement.setInt(1, id);
			rs = pstatement.executeQuery();
			if (rs.next()) {
				ent = new ProductEntity();
				ent.setId(rs.getInt("id"));
				ent.setName(rs.getString("name"));
				ent.setLot(rs.getInt("lot"));
				ent.setPrice(rs.getInt("price"));
			}
			rs.close();
		} finally {
			pstatement.close();
		}
		return ent;
	}
}