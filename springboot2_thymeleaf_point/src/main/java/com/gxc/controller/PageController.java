package com.gxc.controller;

import com.gxc.entity.User;
import com.gxc.repository.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Thymeleaf 测试.
 * @author 宫新程
 * @date 2018/9/9 14:44
 */
@Controller
public class PageController {

  @Resource
  private UserRepository userRepository;

  @RequestMapping("/page/index")
  public String showPage(Model model) {
    model.addAttribute("data","GXC is cool !");
    model.addAttribute("hello","Hello World !");
    model.addAttribute("userId","888");
    return "index";
  }

  @RequestMapping("/submit/{userId}")
  @ResponseBody
  public String submit(String username, @PathVariable String userId) {
    return username + "：" + userId;
  }

  @RequestMapping("/submit")
  @ResponseBody
  public String submit2(String hello, String userId, String username) {
    return hello + "：" + username + "：" + userId;
  }

  @RequestMapping("/userList")
  public String userList(Model model, HttpSession session) {
//    List<User> userList = new ArrayList<>();
//    for(int i = 0; i < 10; i++) {
//      User user = new User();
//      user.setId(Long.valueOf(i+""));
//      user.setUserName("admin__" + i);
//      user.setRegTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//      user.setNickName("hello thymeleaf _ " + i);
//      userList.add(user);
//    }
    List<User> userList = userRepository.findAll();
    model.addAttribute("userList",userList);
    model.addAttribute("hello", "hello world");
    model.addAttribute("nowTime", new Date());
    session.setAttribute("loginUser",userList.get(0));
    return "index";
  }

  @RequestMapping("/delete/{id}")
  @ResponseBody
  @Transactional
  public String deleteUser(@PathVariable Long id) {
    this.userRepository.deleteById(id);
    int i  = 100 / 0;
    return "删除成功";
  }



}
