package com.gxc.config;

import com.gxc.filter.ConfigFilter;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBoot中 过滤器 的配置.
 * @author 宫新程
 * @date 2018/9/6 14:23
 */
@Configuration
public class FilterConfig {

  @Bean
  public RemoteIpFilter remoteIpFilter() {
    return new RemoteIpFilter();
  }

  @Bean
  public FilterRegistrationBean<ConfigFilter> myFilter() {
    FilterRegistrationBean<ConfigFilter> registration = new FilterRegistrationBean<>();
    //设置拦截器
    registration.setFilter(new ConfigFilter());
    //添加过滤请求路径
    List<String> urlList = new ArrayList<>();
    urlList.add("/*");
    registration.setUrlPatterns(urlList);

    //或者
    registration.addUrlPatterns("/*");

    //设置拦截器顺序
    registration.setOrder(1);

    return registration;
  }

  @Bean //配置编码过滤器：注意 spring.http.encoding.enabled=false 才可用
  public FilterRegistrationBean encodingFilter() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    //设置编码过滤器
    CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
    encodingFilter.setForceEncoding(true);
    encodingFilter.setEncoding("UTF-8");
    registrationBean.setFilter(encodingFilter);
    //需要过滤的URL
    registrationBean.addUrlPatterns("/*");

    return registrationBean;
  }

}
