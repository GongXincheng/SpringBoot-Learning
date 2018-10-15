package com.gxc.controller;

import com.gxc.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试.
 *
 * @author 宫新程
 * @since 2018/10/11 15:24
 */
@Controller
public class TestController {

  @RequestMapping("/testList")
  public String testList(Model model) {
    List<User> userList = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      User user = new User();
      user.setId(i);
      user.setAge(i + 10);
      user.setUserName("user: " + i);
      userList.add(user);
    }
    model.addAttribute("num", 1);
    model.addAttribute("userList", userList);
    return "testList";
  }
}
