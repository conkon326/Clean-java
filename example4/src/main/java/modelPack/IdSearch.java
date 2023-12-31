package modelPack;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class IdSearch {
	public void execute(HttpServletRequest request) throws Exception {
		DaoTest daoTest = null;
		String id = request.getParameter("paramId");
		try {
			if (id != null && !id.equals("")) {
				daoTest = new DaoTest();
				ProductEntity ent = daoTest.getSweetsDataById(Integer.parseInt(id));
				if (ent != null) {
					request.setAttribute("sweets", ent);
				} else {
					request.setAttribute("message", "該当はありませんよ");
				}
			} else {
				request.setAttribute("message", "ID を入力してくださいyoyo");
			}
		} catch (NumberFormatException e) {
			request.setAttribute("message", "数値を入力して下さいyo");
		} catch (SQLException e) {
			request.setAttribute("message", "JDBC のエラーです");
		} finally {
			if (daoTest != null) {
				daoTest.close();
			}
		}
	}
}
