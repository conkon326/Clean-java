package controllerPack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelPack.IdSearch;

public class ControlServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");

		try {
			IdSearch ids = new IdSearch();
			ids.execute(req);
		} catch (Exception e) {
			req.setAttribute("message", "åüçıèåèÇì¸óÕÇµÇƒâ∫Ç≥Ç¢");
		}
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/search.jsp");
		rd.forward(req, resp);
	}
}