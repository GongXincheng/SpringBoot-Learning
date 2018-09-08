package com.gxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.gxc.servlet", "com.gxc.filter"}) // 配置Servlet扫描，filter扫描
public class WebAppApplication {
  public static void main(String[] args) {
    SpringApplication.run(WebAppApplication.class, args);
  }
}
