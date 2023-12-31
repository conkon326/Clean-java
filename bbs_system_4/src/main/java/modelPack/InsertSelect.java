package modelPack;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class InsertSelect {
	public void execute(HttpServletRequest request) throws Exception {

		BbsDao dao = null;
		int rowsAffected = 0;
		int threadId;

		try {
			threadId = Integer.parseInt(request.getParameter("threadId"));
			//			System.out.println(threadId);
			dao = new BbsDao();
			rowsAffected = dao.bbsInsert(threadId, request.getParameter("speaker"), request.getParameter("comment"));

			if (rowsAffected == 0) {
				request.setAttribute("message", "追加に失敗しました");
			} else {
				request.setAttribute("message", "追加されました");
			}
		} catch (SQLException e) {
			request.setAttribute("message", "JDBCのエラーです");
		}

		if (dao != null) {
			dao.close();
		}
	}
}
