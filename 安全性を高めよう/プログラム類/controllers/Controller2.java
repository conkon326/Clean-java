package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TextDao;


/**
 * スレッド一覧表示用コントロール
 *
 * @author N.Fukuda
 */


public class Controller2 extends HttpServlet {


  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    req.setCharacterEncoding("Windows-31J");

    TextDao dao = null;
    try{
      dao = new TextDao();

      if(req.getParameter("text3")!=null){

          String text = req.getParameter("text3");
    	  dao.insText1(text);

      }else if(req.getParameter("text4")!=null){

          String text = req.getParameter("text4");
    	  dao.insText2(text);

      }

      ArrayList<String> list = dao.selText();

      req.setAttribute("list", list);

    } catch(Exception e) {
      req.setAttribute("message","原因不明のエラーです");
      e.printStackTrace();

    } finally {
      dao.close();
    }

    //出力
    ServletContext context = getServletContext();
    RequestDispatcher rd = context.getRequestDispatcher("/in_out.jsp");
    rd.forward(req, resp);
  }

}