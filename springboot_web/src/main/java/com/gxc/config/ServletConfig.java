package com.gxc.config;

import com.gxc.servlet.ConfigServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 宫新程
 * @date 2018/9/8 22:00
 */
@Configuration
public class ServletConfig {

  @Bean
  public ServletRegistrationBean configServlet() {
    //方式一：
//    ServletRegistrationBean registrationBean = new ServletRegistrationBean();
//    registrationBean.setServlet(new ConfigServlet());
//    List<String> mapping = new ArrayList<>();
//    mapping.add("/configServlet");
//    registrationBean.setUrlMappings(mapping);

    //方式二：
    ServletRegistrationBean registrationBean = new ServletRegistrationBean<>(new ConfigServlet(), "/configServlet");
    return registrationBean;
  }

}
