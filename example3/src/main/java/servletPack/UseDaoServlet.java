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
		//■リクエスト処理■
		req.setCharacterEncoding("Windows-31J");
		//入力されたid をパラメータから取得
		String paramId = req.getParameter("paramId");

		//		入力された金額の上限下限をパラメーターから取得
		String paramPrice1 = req.getParameter("paramPrice1");
		String paramPrice2 = req.getParameter("paramPrice2");

		//id が指定されているか判定
		String result = null;
		if (paramId != null && !paramId.equals("")) {
			result = idSearch(paramId);
		}

		//金額が指定されているか判定
		else if (paramPrice1 != null && !paramPrice1.equals("") && paramPrice2 != null && !paramPrice2.equals("")) {
			result = priceSearch(paramPrice1, paramPrice2);
		}
		//パラメータが無い場合
		else {
			result = "<p>検索条件を入力して下さい</p>";
		}
		//■レスポンス処理■
		resp.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"Windows-31J\">");
		out.println("<style>");
		out.println("th{ background-color:#FF9900; }");
		out.println("</style>");
		out.println("<title>検索結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>検索結果</h1>");
		out.println(result);
		out.println("<p><a href=\"search.html\">検索ページへ戻る</a></p>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	//▼引数に指定されたid からDAO を利用してデータを取得し、出力データを生成
	public String idSearch(String paramId) {
		String result = null;
		DaoTest daoTest = null;
		try {
			int empId = Integer.parseInt(paramId);
			daoTest = new DaoTest();
			String[] empData = daoTest.getSweetsDataById(empId);
			if (empData == null) {
				result = "<p>該当はありません</p>";
			} else {
				result = "<table border=\"1\" summary=\"検索結果をまとめた表\">"
						+ "<tr><th>ID</th><th>名前</th><th>金額</th></tr>"
						+ "<tr><td>" + empData[0] + "</td><td>" + empData[1] + "</td><td>" +
						empData[2] + "</td></tr></table>";
			}
		} catch (NumberFormatException e) {
			result = "<p>数値を入力して下さい</p>";
			e.printStackTrace();
		} catch (SQLException e) {
			result = "<p>JDBC のエラーです</p>";
			e.printStackTrace();
		} catch (Exception e) {
			result = "<p>エラーです</p>";
			e.printStackTrace();
		} finally {
			if (daoTest != null) {
				daoTest.close();
			}
		}
		return result;
	}

	//▼引数に指定された金額 からDAO を利用してデータを取得し、出力データを生成
	public String priceSearch(String paramPrice1, String paramPrice2) {
		String result = null;
		DaoTest daoTest = null;
		try {

			int price1 = Integer.parseInt(paramPrice1);
			int price2 = Integer.parseInt(paramPrice2);

			daoTest = new DaoTest();

			ArrayList<String[]> empData = daoTest.getSweetsDataByPrice(price1, price2);
			if (empData == null || empData.isEmpty()) {
				result = "<p>該当はありません</p>";
			} else {
				result = "<table border=\"1\" summary=\"検索結果をまとめた表\">"
						+ "<tr><th>ID</th><th>名前</th><th>金額</th></tr>";
				for (String[] emp : empData) {
					result += "<tr><td>" + emp[0] + "</td><td>" + emp[1] + "</td><td>" +
							emp[2] + "</td></tr>";
				}
				result += "</table>";

			}

		} catch (NumberFormatException e) {
			result = "<p>数値を入力して下さい</p>";
			e.printStackTrace();
		} catch (SQLException e) {
			result = "<p>JDBC のエラーです</p>";
			e.printStackTrace();
		} catch (Exception e) {
			result = "<p>エラーです</p>";
			e.printStackTrace();
		} finally {
			if (daoTest != null) {
				daoTest.close();
			}
		}
		return result;
	}
}
