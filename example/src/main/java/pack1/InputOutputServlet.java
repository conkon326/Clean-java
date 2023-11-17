package pack1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputOutputServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		resp.setContentType("text/html; charset=Windows-31J");

		String data = req.getParameter("data");
		String message = "入力してください";

		if (data != null && !data.equals("")) {
			message = "doGet()メソッドが動きました。<br>" + data + "を入力しましたね。";
		}

		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"Windows-31J\">");
		out.println("<title>Servlet InputOutput</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("Windows-31J");
		resp.setContentType("text/html; charset=Windows-31J");

		String data = req.getParameter("data");
		String message = "入力してください";

		if (data != null && !data.equals("")) {
			message = "doPost()メソッドが動きました。<br>" + data + "を入力しましたね。";
		}

		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"Windows-31J\">");
		out.println("<title>Servlet InputOutput</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
