package com.gxc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * SpringBoot 的 AOP
 * @author 宫新程
 * @date 2018/9/10 14:37
 */
@Aspect
@Component
public class RequestAspect {

  private Logger logger = LoggerFactory.getLogger(RequestAspect.class);

  //切点
  @Pointcut("execution(* com.gxc.controller.*.*(..))")
  public void log(){}

  @Before("log()")
  public void doBefore(JoinPoint joinPoint) {
    logger.info("方法执行前....");
    ServletRequestAttributes requestAttributes =
        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = requestAttributes.getRequest();
    logger.info("请求URL：{}", request.getRequestURL());
    logger.info("请求IP：{}", request.getRemoteHost());
    logger.info("请求方法：{}", request.getMethod());
    logger.info("class_method：{}", joinPoint.getSignature().getDeclaringTypeName() + "：" + joinPoint.getSignature().getName());
    logger.info("args：{}", joinPoint.getArgs());
  }

  @After("log()")
  public void doAfter(JoinPoint joinPoint) {
    logger.info("方法执行后....");
  }

  @AfterReturning(returning = "result", pointcut = "log()")
  public void doReturn(Object result) {
    logger.info("方法方法的返回值.... {}", result);
  }
}
