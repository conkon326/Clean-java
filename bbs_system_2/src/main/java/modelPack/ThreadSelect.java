package modelPack;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class ThreadSelect {
	public void execute(HttpServletRequest request) throws Exception {

		BbsDao dao = null;
		ArrayList<BbsEntity> bbsList = null;

		try {
			dao = new BbsDao();
			bbsList = dao.getThreadsTop();

			if (bbsList != null) {
				request.setAttribute("bbsList", bbsList);
			}
			
		} catch (SQLException e) {
			request.setAttribute("message", "JDBCÇÃÉGÉâÅ[Ç≈Ç∑");
		}

		if (dao != null) {
			dao.close();
		}
		
	}
}
