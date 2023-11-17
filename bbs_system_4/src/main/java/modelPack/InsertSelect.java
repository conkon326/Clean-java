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
				request.setAttribute("message", "í«â¡Ç…é∏îsÇµÇ‹ÇµÇΩ");
			} else {
				request.setAttribute("message", "í«â¡Ç≥ÇÍÇ‹ÇµÇΩ");
			}
		} catch (SQLException e) {
			request.setAttribute("message", "JDBCÇÃÉGÉâÅ[Ç≈Ç∑");
		}

		if (dao != null) {
			dao.close();
		}
	}
}
