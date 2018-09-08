package com.gxc.controller;

import com.gxc.dao.UserRepository;
import com.gxc.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * UserController.
 * @author 宫新程
 * @date 2018/9/6 22:11
 */
@Controller
public class UserController {

  @Autowired
  private UserRepository userRepository;

  /**
   * 测试单个属性.
   * @param model Model
   * @return 页面
   */
  @RequestMapping("/message")
  public String test(Model model) {
    model.addAttribute("message", "Hello ThymeLeaf");
    return "world";
  }

  @RequestMapping("listUsers")
  public String listUsers(Model model) {
    List<User> users = userRepository.findAll();
    model.addAttribute("userList", users);
    return "index";
  }

  @RequestMapping("/delete/{id}")
  @ResponseBody
  public String deleteUser(@PathVariable Long id) {
    this.userRepository.deleteById(id);
    return "删除成功: " + id;
  }

}
