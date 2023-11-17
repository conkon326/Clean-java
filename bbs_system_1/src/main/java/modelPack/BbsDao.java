package modelPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BbsDao {
	private Connection connection;

	public BbsDao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://172.19.7.80/bbs_db?useUnicode=true&characterEncoding=MS932&user=testu&password=testp");
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

	public ArrayList<BbsEntity> getAllData() throws SQLException {
		ArrayList<BbsEntity> bbsList = new ArrayList<>();

		PreparedStatement pstatement = null;
		ResultSet rs = null;

		try {
			pstatement = connection.prepareStatement("SELECT * FROM bbs_tbl ORDER BY thread_id ASC, ymdhms ASC");
			rs = pstatement.executeQuery();
			while (rs.next()) {
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
			if (pstatement != null) {
				pstatement.close();
			}
		}
		return bbsList;
	}

	
	public int bbsInsert(int threadId, String speaker, String comment) throws SQLException {
	    PreparedStatement pstatement = null;
	    int rowsAffected = 0;
	    try {
	    	pstatement = connection.prepareStatement("INSERT INTO bbs_db.bbs_tbl (thread_id, speaker, content, ymdhms) VALUES (?, ?, ?, ?);");
	        pstatement.setInt(1, threadId);
	        pstatement.setString(2, speaker);
	        pstatement.setString(3, comment);
	        pstatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

	    } finally {
	        if (pstatement != null) {
	        	System.out.println(pstatement);
	            pstatement.close();
	        }
	    }

	    return rowsAffected;
	}

}
