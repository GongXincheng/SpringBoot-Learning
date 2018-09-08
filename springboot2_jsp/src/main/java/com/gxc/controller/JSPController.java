package com.gxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试JSP页面的显示.
 * @author 宫新程
 * @date 2018/9/8 8:39
 */
@Controller
public class JSPController {

  @RequestMapping("/{page}")
  public String showPage(@PathVariable String page, Model model) {
    model.addAttribute("message","Hello Jsp");
    return page;
  }

}
