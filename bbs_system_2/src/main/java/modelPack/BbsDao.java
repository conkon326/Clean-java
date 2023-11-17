package modelPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

public class BbsDao {
	private Connection connection;

	public BbsDao() throws ClassNotFoundException, SQLException {
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

	public ArrayList<Entity> getThreadsTop() throws SQLException {

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			pst = connection
					.prepareStatement("SELECT t1.* FROM bbs_tbl t1 JOIN " +
							"(SELECT thread_id, MIN(ymdhms) AS first_post_date" +
							"  FROM bbs_tbl" +
							"  GROUP BY thread_id) " +
							"t2 ON t1.thread_id = t2.thread_id AND t1.ymdhms = t2.first_post_date;");
			rs = pst.executeQuery();
			ifrs.next()) {
				int threadId = rs.getInt("thread_id");
				String speaker = rs.getString("speaker");
				String content = rs.getString("content");
				Timestamp ymdhms = rs.getTimestamp("ymdhms");

				BbsEntity bbsEntity = new BbsEntity(threadId, speaker, content, ymdhms);
				bbsList.add(bbsEntity);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		}
		return bbsList;
	}

	public int calculateValue() {
        int year = 1900;
        int month = 1;
        int day = 1;

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
}
