package com.gxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 宫新程
 * @date 2018/9/6 23:15
 */
@Controller
public class PageController {


  @RequestMapping("/index")
  public String index(Model model) {
    model.addAttribute("message","尾巴");
    return "index";
  }


}
