package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.MemberDao;


/**
 * スレッド一覧表示用コントロール
 *
 * @author N.Fukuda
 */


public class Controller1 extends HttpServlet {


  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    req.setCharacterEncoding("Windows-31J");


    String check = null;
    MemberDao dao = null;
    try{
      dao = new MemberDao();

      if(req.getParameter("name1")!=null){

        check = dao.checkMembers1( req.getParameter("name1"),
                                   req.getParameter("pass1")
                         );
        req.setAttribute("message", check);

      }else if(req.getParameter("name2")!=null){

        check = dao.checkMembers2( req.getParameter("name2"),
                                   req.getParameter("pass2")
                                 );
        req.setAttribute("message", check);

      }else if(req.getParameter("text1")!=null){

        check = req.getParameter("text1");

        req.setAttribute("message", check);

      }
      else if(req.getParameter("text2")!=null){

          check = req.getParameter("text2").replaceAll("<", "&lt;").replaceAll(">", "&gt;");

          req.setAttribute("message2", check);

      }

    } catch(Exception e) {
      req.setAttribute("message","原因不明のエラーです");
      e.printStackTrace();

    } finally {
      dao.close();
    }

    //出力
    ServletContext context = getServletContext();
    RequestDispatcher rd = context.getRequestDispatcher("/output.jsp");
    rd.forward(req, resp);
  }

}