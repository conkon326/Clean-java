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

	// �R���X�g���N�^: �f�[�^�x�[�X�ڑ���������
	public BbsDao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://172.19.7.80/bbs_db?useUnicode=true&characterEncoding=MS932&user=testu&password=testp");
	}

	// �f�[�^�x�[�X�ڑ����N���[�Y
	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BbsDto> getThreadsTopWithPostCount() throws SQLException {
		ArrayList<BbsDto> bbsList = new ArrayList<>();

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			// �X���b�h�ꗗ�擾��SQL�N�G��
			pst = connection.prepareStatement(
					"SELECT t1.*, t2.post_count" +
							" FROM bbs_tbl AS t1 " +
							" JOIN (" +
							" SELECT thread_id, MIN(ymdhms) AS first_post_date, COUNT(*) AS post_count " +
							" FROM bbs_tbl AS t3 " +
							" GROUP BY thread_id" +
							" ) AS t2 ON t1.thread_id = t2.thread_id AND t1.ymdhms = t2.first_post_date " +
							" ORDER BY t1.ymdhms DESC " +
							" LIMIT 20");
			System.out.println(pst);
			rs = pst.executeQuery();
			while (rs.next()) {
				int threadId = rs.getInt("thread_id");
				String content = rs.getString("content");
				int postCount = rs.getInt("post_count");

				BbsDto bbsEntity = new BbsDto(threadId, content, postCount);
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

	//�X���b�h�ꗗ(�e�X���b�h�̍ł��Â����R�[�h�Ɠ��e��)���y�[�W���ƂɎ擾 ����
	public ArrayList<BbsDto> getThreadsTopWithPostCount(String page) throws SQLException {
		ArrayList<BbsDto> bbsList = new ArrayList<>();

		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			// �X���b�h�ꗗ�擾��SQL�N�G��
			pst = connection
					.prepareStatement(
							"SELECT t1.*, t2.post_count" +
									" FROM bbs_tbl AS t1 " +
									" JOIN (" +
									" SELECT thread_id, MIN(ymdhms) AS first_post_date, COUNT(*) AS post_count " +
									" FROM bbs_tbl AS t3 " +
									" GROUP BY thread_id" +
									" ) AS t2 ON t1.thread_id = t2.thread_id AND t1.ymdhms = t2.first_post_date " +
									" ORDER BY t1.ymdhms " +
									" LIMIT 20 OFFSET ?");

			pst.setInt(1, 20 * (Integer.parseInt(page) - 1));
//			System.out.println(pst);
			rs = pst.executeQuery();
			while (rs.next()) {
				int threadId = rs.getInt("thread_id");
				String content = rs.getString("content");
				int postCount = rs.getInt("post_count");

				BbsDto bbsEntity = new BbsDto(threadId, content, postCount);
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

	//	�X���b�h�^�C�g���̎擾
	public BbsEntity getThreadsTitleById(String id) throws SQLException {
		BbsEntity threadsTitle = null; // null�ŏ�����
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			// ����̃X���b�hID�Ɋ֘A���郌�R�[�h���擾����SQL�N�G��
			pst = connection.prepareStatement("SELECT * FROM bbs_tbl WHERE thread_id = ? ORDER BY ymdhms limit 1");
			pst.setInt(1, Integer.parseInt(id));
			rs = pst.executeQuery();

			if (rs.next()) {
				int threadId = rs.getInt("thread_id");
				String speaker = rs.getString("speaker");
				String content = rs.getString("content");
				Timestamp ymdhms = rs.getTimestamp("ymdhms");

				threadsTitle = new BbsEntity(threadId, speaker, content, ymdhms);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		}

		return threadsTitle;
	}

	// ����X���b�hID�Ɋ֘A���郌�R�[�h���擾
	public ArrayList<BbsEntity> getThreadsById(String id) throws SQLException {
		ArrayList<BbsEntity> threadDatas = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			// ����X���b�hID�Ɋ֘A���郌�R�[�h�擾��SQL�N�G��
			pst = connection
					.prepareStatement(
							"SELECT * FROM bbs_tbl"
									+ " WHERE thread_id = ?"
									+ " AND ymdhms > ("
									+ " SELECT ymdhms FROM bbs_tbl"
									+ " WHERE thread_id = ?"
									+ " ORDER BY ymdhms ASC"
									+ " LIMIT 1"
									+ " )"
									+ " ORDER BY ymdhms DESC"
									+ " LIMIT 20");
			pst.setInt(1, Integer.parseInt(id));
			pst.setInt(2, Integer.parseInt(id));

			rs = pst.executeQuery();
			while (rs.next()) {
				int threadId = rs.getInt("thread_id");
				String speaker = rs.getString("speaker");
				String content = rs.getString("content");
				Timestamp ymdhms = rs.getTimestamp("ymdhms");

				BbsEntity bbsEntity = new BbsEntity(threadId, speaker, content, ymdhms);
				threadDatas.add(bbsEntity);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		}

		return threadDatas;
	}

	// ����X���b�hID�Ɋ֘A���郌�R�[�h���y�[�W���ƂɎ擾(����)
	public ArrayList<BbsEntity> getThreadsById(String id, String page)
			throws SQLException {
		ArrayList<BbsEntity> threadDatas = new ArrayList<>();
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			// �y�[�W���Ƃ̓���X���b�hID�Ɋ֘A���郌�R�[�h�擾��SQL�N�G��
			pst = connection
					.prepareStatement(
							"SELECT * FROM bbs_tbl"
									+ " WHERE thread_id = ?"
									+ " AND ymdhms > ("
									+ " SELECT ymdhms FROM bbs_tbl"
									+ " WHERE thread_id = ?"
									+ " ORDER BY ymdhms ASC"
									+ " LIMIT 1"
									+ " )"
									+ " ORDER BY ymdhms ASC"
									+ " LIMIT 20 offset ?");

			pst.setInt(1, Integer.parseInt(id));
			pst.setInt(2, Integer.parseInt(id));
			pst.setInt(3, 20 * (Integer.parseInt(page) - 1));

			//			System.out.println(pst);

			rs = pst.executeQuery();
			while (rs.next()) {
				int threadId = rs.getInt("thread_id");
				String speaker = rs.getString("speaker");
				String content = rs.getString("content");
				Timestamp ymdhms = rs.getTimestamp("ymdhms");
				BbsEntity bbsEntity = new BbsEntity(threadId, speaker, content, ymdhms);
				threadDatas.add(bbsEntity);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
		}

		return threadDatas;
	}

	// �X���b�h�̑������擾
	public int getThreadCount() throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;

		try {
			// �X���b�h�̑����擾��SQL�N�G��
			pst = connection.prepareStatement("SELECT COUNT(DISTINCT thread_id)AS count FROM bbs_tbl;");
			rs = pst.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}

		}
		return count;
	}

	// ����X���b�h�ɑ΂���R�����g�i���X�|���X�j�̑������擾
	public int getResCount(String id) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;

		try {
			// ����X���b�h�ɑ΂���R�����g�̑����擾��SQL�N�G��
			pst = connection.prepareStatement("SELECT COUNT(*) AS count FROM bbs_tbl WHERE thread_id = ?");
			pst.setInt(1, Integer.parseInt(id));
			//			System.out.println(pst);
			rs = pst.executeQuery();

			if (rs.next()) {
				count = rs.getInt("count");
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}

		}

		return count;
	}

	// �V�����X���b�h�܂��͊����̃X���b�h�ւ̃R�����g��}��
	public int bbsInsert(int threadId, String speaker, String comment) throws SQLException {
		PreparedStatement pst = null;
		int rowsAffected = 0;

		try {

			if (threadId == 0) {
				// �X���b�h�ւ̃R�����g�}����SQL�N�G��
				pst = connection.prepareStatement(
						"INSERT INTO bbs_db.bbs_tbl (thread_id, speaker, content, ymdhms)"
								+ " SELECT IFNULL(MAX(thread_id), 0) + 1, ?, ?, ? FROM bbs_db.bbs_tbl;");
				pst.setString(1, speaker);
				pst.setString(2, comment);
				pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			} else {
				// �����̃X���b�h�ւ̕ԐM��}������ꍇ��SQL��
				pst = connection.prepareStatement(
						"INSERT INTO bbs_db.bbs_tbl (thread_id, speaker, content, ymdhms) VALUES ("
								+ "?, ?, ?, ?);");
				pst.setInt(1, threadId);
				pst.setString(2, speaker);
				pst.setString(3, comment);
				pst.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

			}

			rowsAffected = pst.executeUpdate();

		} finally {
			if (pst != null) {
				pst.close();
			}
		}
		return rowsAffected;
	}
}
