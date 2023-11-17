package rg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class Dao {
	private Connection connection;

	public Dao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager
				.getConnection("jdbc:mysql://localhost/animal_ft" +
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

	public int calculateValue(String inputYear, String inputMonth, String inputDay) {
		int year = Integer.parseInt(inputYear);
		int month = Integer.parseInt(inputMonth);
		int day = Integer.parseInt(inputDay);

		Calendar cal1 = Calendar.getInstance();
		cal1.set(1910, 0, 1);
		long date1 = cal1.getTimeInMillis();

		Calendar cal2 = Calendar.getInstance();
		cal2.set(year, month - 1, 1);
		long date2 = cal2.getTimeInMillis();

		long distance = (date2 - date1) / (1000 * 60 * 60 * 24);
		int kansan = (int) (distance + 2) % 60;

		// 60•ª—Þ‚Ì’l‚ðŒvŽZ
		int value = (kansan + day);
		if (value > 60) {
			value = value - 60;
		}

		return value;
	}

	public SixtyAnimalsEntity getSixtyAnimals(int id)
			throws SQLException {
		SixtyAnimalsEntity threadData = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = connection
					.prepareStatement(
							"SELECT * FROM 60animals WHERE 60id = ?");

			pst.setInt(1, id);

			System.out.println(pst);

			rs = pst.executeQuery();
			if (rs.next()) {
				int twelveid = rs.getInt("12id");
				String name = rs.getString("name");

				threadData = new SixtyAnimalsEntity(twelveid, name);

			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		}

		return threadData;
	}

	public String getPicture(int id)
			throws SQLException {
		String picture = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = connection
					.prepareStatement(
							"SELECT * FROM 12animals WHERE 12id = ?");

			pst.setInt(1, id);
			System.out.println(pst);

			rs = pst.executeQuery();
			if (rs.next()) {
				picture = rs.getString("picture");
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		}

		return picture;
	}

}
