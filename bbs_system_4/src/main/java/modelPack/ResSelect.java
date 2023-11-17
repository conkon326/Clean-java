package modelPack;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ResSelect {
	public void execute(HttpServletRequest request) throws Exception {

		BbsDao dao = null;
		ArrayList<BbsEntity> bbsList = null;
		BbsEntity threadsTitle = null;

		int recordCount = 0;
		String id = (String) request.getParameter("threadId");

		try {
			dao = new BbsDao();
			threadsTitle = dao.getThreadsTitleById(id);
			if (request.getParameter("page") != null) {
				bbsList = dao.getThreadsById(id, (String) request.getParameter("page"));
			} else {
				bbsList = dao.getThreadsById(id);
			}

			recordCount = dao.getResCount(id) - 1;
			//			System.out.println(recordCount);
			String pages = Utilities.editPages("resControlServlet", id, recordCount);

			if (bbsList != null) {
				request.setAttribute("threadsTitle", threadsTitle);

				request.setAttribute("bbsList", bbsList);
				request.setAttribute("pages", pages);
			}
		} catch (SQLException e) {
			request.setAttribute("message", "JDBCÇÃÉGÉâÅ[Ç≈Ç∑");
		}

		if (dao != null) {
			dao.close();
		}
	}
}
