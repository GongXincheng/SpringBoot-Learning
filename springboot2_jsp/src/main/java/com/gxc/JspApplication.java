package com.gxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * SpringBoot打war包部署的时，
 *  启动类需要继承 SpringBootServletInitializer
 *  并重写 configure 方法.
 */
@SpringBootApplication
public class JspApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(JspApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(JspApplication.class, args);
  }
}
