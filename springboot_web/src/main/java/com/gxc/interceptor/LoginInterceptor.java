package com.gxc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 练习SpringBoot的拦截器的配置.
 * @author 宫新程
 * @date 2018/9/8 21:00
 */
public class LoginInterceptor implements HandlerInterceptor {

  private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

  @Override
  public boolean preHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    logger.info("日志打印：{}",request.getRequestURL().toString());

    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

  }

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {

  }
}
