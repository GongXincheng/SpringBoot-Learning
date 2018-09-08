package com.gxc.config;

import com.gxc.interceptor.LoginInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器(Interceptor)在SpringBoot中的配置
 *  注意：配置类需要继承 WebMvcConfigurationSupport 类
 *  重写：addInterceptors 方法.
 * @author 宫新程
 * @date 2018/9/8 21:06
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

  @Override
  protected void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/api/login");
  }
}
