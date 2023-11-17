package modelPack;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ThreadSelect {
	public void execute(HttpServletRequest request) throws Exception {

		BbsDao dao = null;
		ArrayList<BbsDto> bbsList = null;
		int recordCount = 0;

		try {
			dao = new BbsDao();
			if (request.getParameter("page") != null) {
				bbsList = dao.getThreadsTopWithPostCount((String) request.getParameter("page"));
			} else {
				bbsList = dao.getThreadsTopWithPostCount();
			}
			recordCount = dao.getThreadCount();
			String pages = Utilities.editPages("threadControlServlet", "", recordCount);

			if (bbsList != null) {
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
