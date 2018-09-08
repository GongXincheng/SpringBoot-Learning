package com.gxc.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gxc.entity.User;
import com.gxc.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 消费者Controller
 * @author 宫新程
 * @date 2018/9/8 20:26
 */

@Controller
public class UserController {

  //@Reference(version = "1.0.0")
  @Reference()
  public UserService userService;

  @RequestMapping("/dubbo/{id}")
  @ResponseBody
  public Object dubbo(@PathVariable Integer id) {
    User user = userService.getUser(id);
    return user;
  }

  @RequestMapping("/dubboTest")
  @ResponseBody
  public Object dubbo2() {
    String gxc = userService.sayHi("GXC");
    return gxc;
  }

}
