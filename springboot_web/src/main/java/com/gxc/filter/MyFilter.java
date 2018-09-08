package com.gxc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * 方式一：注解式 Filter.
 *  注意：main方法上需要加注解
 * @author 宫新程
 * @date 2018/9/6 14:18
 */
@WebFilter(urlPatterns = "/*")
public class MyFilter implements Filter {

  private final Logger log = LoggerFactory.getLogger(MyFilter.class);

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    log.info("MyFilter__请求路径：{}",request.getRequestURL());
    filterChain.doFilter(servletRequest,servletResponse);
  }

  @Override
  public void destroy() {

  }
}
