package com.gxc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 方式二：使用配置式Servlet.
 *
 * @author 宫新程
 * @date 2018/9/8 21:59
 */
public class ConfigServlet extends HttpServlet {

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doPost(req, resp);
  }

  @Override
  protected void doPost(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("配置式 Serlvet ____" + this.getClass().getSimpleName());
  }
}
