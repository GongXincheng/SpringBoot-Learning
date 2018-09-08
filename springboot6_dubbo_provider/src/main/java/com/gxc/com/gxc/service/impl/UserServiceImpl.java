package com.gxc.com.gxc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.gxc.entity.User;
import com.gxc.service.UserService;

import org.springframework.stereotype.Component;

/**
 * @author 宫新程
 * @date 2018/9/8 17:00
 */
@Component
//@Service(version = "1.0.0", timeout = 60000)  //注意：使用dubbo的注解，启动类还需要加注解
@Service(timeout = 60000)  //注意：使用dubbo的注解，启动类还需要加注解
public class UserServiceImpl implements UserService {

  @Override
  public String sayHi(String name) {
    return "Hi Spring Boot Dubbo：" + name;
  }

  @Override
  public User getUser(int id) {
    //查询数据库
    User user = new User();
    user.setId(id);
    user.setName("GXC");
    user.setPhone("15021440016");
    return user;
  }
}
