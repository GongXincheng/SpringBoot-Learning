package com.gxc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 宫新程
 * @since 2018/09/21 16:59
 */
public class LoginFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    StringBuffer requestURL = request.getRequestURL();
    System.out.println(requestURL.toString());
    filterChain.doFilter(request,servletResponse);
  }

  @Override
  public void destroy() {

  }
}
