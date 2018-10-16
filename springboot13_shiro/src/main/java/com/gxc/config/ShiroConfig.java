package com.gxc.config;

import com.gxc.realm.MyShiroRealm;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 宫新程
 * @since 2018/10/15 18:03
 */
@Configuration
public class ShiroConfig {

  private static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

  /**
   * Realm. 配置.
   *
   * @return
   */
  @Bean
  public MyShiroRealm myShiroRealm() {
    MyShiroRealm myShiroRealm = new MyShiroRealm();
    return myShiroRealm;
  }

  /**
   * 配置 SecurityManager.
   *
   * @return
   */
  @Bean
  public SecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(myShiroRealm());
    return securityManager;
  }

  /**
   * 配置 ShiroFilterFactoryBean.
   * @param securityManager
   * @return
   */
  @Bean
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    logger.info("初始化 ShiroFilterFactoryBean ...");
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

    // 设置 securityManager
    shiroFilterFactoryBean.setSecurityManager(securityManager);

    // 拦截器.
    Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
    // 配置不会被拦截的链接 顺序判断
    filterChainDefinitionMap.put("/static/**", "anon");
    // 配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
    filterChainDefinitionMap.put("/logout", "logout");
    // <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
    // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
    filterChainDefinitionMap.put("/**", "authc");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

    // 如果不设置默认会自动寻找Web工程根目录下的"/login.html"页面
    shiroFilterFactoryBean.setLoginUrl("/login");
    // 登录成功后要跳转的链接
    shiroFilterFactoryBean.setSuccessUrl("/index");
    // 未授权界面;
    shiroFilterFactoryBean.setUnauthorizedUrl("/403");

    return shiroFilterFactoryBean;
  }
}
