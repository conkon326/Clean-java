package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormSamplesServlet")
public class FormSamplesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		String errorMsg = "";
		if (name == null || name.length() == 0) {

			errorMsg += "���O�����͂���Ă��܂���";
		}
		if (gender == null || gender.length() == 0) {
			errorMsg += "���ʂ��I������Ă��܂���";
		} else {
			if (gender.equals("0")) {
				gender = "�j��";
			} else if (gender.equals("1")) {
				gender = "����";
			}
		}

		String msg = name + "����(" + gender + ")��o�^���܂���";
		if (errorMsg.length() != 0) {
			msg = errorMsg;
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>���[�U�[�o�^</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + msg + "</p>");
		out.println("</body>");
		out.println("</body>");
		out.println("</html>");

	}

}