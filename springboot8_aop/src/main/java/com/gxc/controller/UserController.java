package com.gxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 宫新程
 * @date 2018/9/10 14:43
 */
@Controller
public class UserController {

  @RequestMapping("/aspect")
  @ResponseBody
  public String test() {
    return "Hello World";
  }

}
