package com.gxc.config;

import com.gxc.filter.LoginFilter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * @author 宫新程
 * @since 2018/09/21 16:48
 */
@Configuration
//配置过期时间
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400 * 30)
public class RedisConfig {

  @Bean
  public FilterRegistrationBean<LoginFilter> loginFilter() {
    FilterRegistrationBean<LoginFilter> reg = new FilterRegistrationBean<>();
    reg.setFilter(new LoginFilter());
    List<String> urlList = new ArrayList<>();
    urlList.add("/*");
    reg.setUrlPatterns(urlList);
    return reg;
  }

}
