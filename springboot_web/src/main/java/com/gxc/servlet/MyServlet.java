package com.gxc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 方式一：使用在Servlet上使用注解，
 *  main方法上添加扫描.
 *
 * @author 宫新程
 * @date 2018/9/8 21:49
 */
@WebServlet(urlPatterns = "/servlet")
public class MyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req,resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("___________Welcome Servlet ！_________");
  }
}
