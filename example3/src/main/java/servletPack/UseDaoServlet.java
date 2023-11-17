package servletPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoPack.DaoTest;

public class UseDaoServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�����N�G�X�g������
		req.setCharacterEncoding("Windows-31J");
		//���͂��ꂽid ���p�����[�^����擾
		String paramId = req.getParameter("paramId");

		//		���͂��ꂽ���z�̏���������p�����[�^�[����擾
		String paramPrice1 = req.getParameter("paramPrice1");
		String paramPrice2 = req.getParameter("paramPrice2");

		//id ���w�肳��Ă��邩����
		String result = null;
		if (paramId != null && !paramId.equals("")) {
			result = idSearch(paramId);
		}

		//���z���w�肳��Ă��邩����
		else if (paramPrice1 != null && !paramPrice1.equals("") && paramPrice2 != null && !paramPrice2.equals("")) {
			result = priceSearch(paramPrice1, paramPrice2);
		}
		//�p�����[�^�������ꍇ
		else {
			result = "<p>������������͂��ĉ�����</p>";
		}
		//�����X�|���X������
		resp.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"Windows-31J\">");
		out.println("<style>");
		out.println("th{ background-color:#FF9900; }");
		out.println("</style>");
		out.println("<title>��������</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>��������</h1>");
		out.println(result);
		out.println("<p><a href=\"search.html\">�����y�[�W�֖߂�</a></p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	//�������Ɏw�肳�ꂽid ����DAO �𗘗p���ăf�[�^���擾���A�o�̓f�[�^�𐶐�
	public String idSearch(String paramId) {
		String result = null;
		DaoTest daoTest = null;
		try {
			int empId = Integer.parseInt(paramId);
			daoTest = new DaoTest();
			String[] empData = daoTest.getSweetsDataById(empId);
			if (empData == null) {
				result = "<p>�Y���͂���܂���</p>";
			} else {
				result = "<table border=\"1\" summary=\"�������ʂ��܂Ƃ߂��\\">"
						+ "<tr><th>ID</th><th>���O</th><th>���z</th></tr>"
						+ "<tr><td>" + empData[0] + "</td><td>" + empData[1] + "</td><td>" +
						empData[2] + "</td></tr></table>";
			}
		} catch (NumberFormatException e) {
			result = "<p>���l����͂��ĉ�����</p>";
			e.printStackTrace();
		} catch (SQLException e) {
			result = "<p>JDBC �̃G���[�ł�</p>";
			e.printStackTrace();
		} catch (Exception e) {
			result = "<p>�G���[�ł�</p>";
			e.printStackTrace();
		} finally {
			if (daoTest != null) {
				daoTest.close();
			}
		}
		return result;
	}

	//�������Ɏw�肳�ꂽ���z ����DAO �𗘗p���ăf�[�^���擾���A�o�̓f�[�^�𐶐�
	public String priceSearch(String paramPrice1, String paramPrice2) {
		String result = null;
		DaoTest daoTest = null;
		try {

			int price1 = Integer.parseInt(paramPrice1);
			int price2 = Integer.parseInt(paramPrice2);

			daoTest = new DaoTest();

			ArrayList<String[]> empData = daoTest.getSweetsDataByPrice(price1, price2);
			if (empData == null || empData.isEmpty()) {
				result = "<p>�Y���͂���܂���</p>";
			} else {
				result = "<table border=\"1\" summary=\"�������ʂ��܂Ƃ߂��\\">"
						+ "<tr><th>ID</th><th>���O</th><th>���z</th></tr>";
				for (String[] emp : empData) {
					result += "<tr><td>" + emp[0] + "</td><td>" + emp[1] + "</td><td>" +
							emp[2] + "</td></tr>";
				}
				result += "</table>";

			}

		} catch (NumberFormatException e) {
			result = "<p>���l����͂��ĉ�����</p>";
			e.printStackTrace();
		} catch (SQLException e) {
			result = "<p>JDBC �̃G���[�ł�</p>";
			e.printStackTrace();
		} catch (Exception e) {
			result = "<p>�G���[�ł�</p>";
			e.printStackTrace();
		} finally {
			if (daoTest != null) {
				daoTest.close();
			}
		}
		return result;
	}
}
