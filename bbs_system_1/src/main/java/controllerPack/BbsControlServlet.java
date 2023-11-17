package controllerPack;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelPack.BbsDao;
import modelPack.BbsEntity;

@WebServlet("/bbsControlServlet")
public class BbsControlServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        	BbsDao dao = new BbsDao();
            ArrayList<BbsEntity> bbsList = dao.getAllData();
            dao.close();

            request.setAttribute("bbsList", bbsList);
            request.getRequestDispatcher("/bbsView.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle errors
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int threadId = Integer.parseInt(request.getParameter("threadId"));
            String speaker = request.getParameter("speaker");
            String comment = request.getParameter("comment");

            BbsDao dao = new BbsDao();
            
            int rowsAffected = dao.bbsInsert(threadId, speaker, comment);

            dao.close();

            if (rowsAffected > 0) {
                response.sendRedirect("successPage.jsp");
            } else {
                response.sendRedirect("errorPage.jsp");
            }
        } catch (ClassNotFoundException | SQLException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
