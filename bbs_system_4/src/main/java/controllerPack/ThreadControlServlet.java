package controllerPack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelPack.ThreadSelect;

@WebServlet("/threadControlServlet")
public class ThreadControlServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("Windows-31j");
		try {
			ThreadSelect bs = new ThreadSelect();
			bs.execute(request);

		} catch (Exception e) {
			request.setAttribute("message", "Ç»ÇÒÇÁÇ©ÇÃÉGÉâÅ[Ç™Ç≈ÇƒÇ¢Ç‹Ç∑");
		}

		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/threadView.jsp");
		rd.forward(request, response);
	

	}
}
