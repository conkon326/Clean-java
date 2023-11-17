package controllerPack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelPack.InsertSelect;

@WebServlet("/insertControlServlet")
public class InsertControlServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("Windows-31j");
		try {
			InsertSelect ins = new InsertSelect();
			ins.execute(request);

		} catch (Exception e) {
			request.setAttribute("message", "Ç»ÇÒÇÁÇ©ÇÃÉGÉâÅ[Ç™Ç≈ÇƒÇ¢Ç‹Ç∑");
		}

		ServletContext context = getServletContext();
		if (request.getParameter("threadId").equals("0")) {
			response.sendRedirect("threadControlServlet");
		} else {
			RequestDispatcher rd = context.getRequestDispatcher("/resControlServlet");
			rd.forward(request, response);
		}

	}
}
