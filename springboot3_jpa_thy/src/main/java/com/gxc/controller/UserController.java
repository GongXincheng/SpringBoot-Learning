package com.gxc.controller;

import com.gxc.dao.UserRepository;
import com.gxc.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 宫新程
 * @date 2018/9/7 10:50
 */
@Controller
public class UserController {

  @Autowired private UserRepository userRepository;

  @RequestMapping("/list")
  public String userList(
      @RequestParam(defaultValue = "0") Integer page,
      @RequestParam(defaultValue = "10") Integer size,
      Model model) {

    Sort sort = new Sort(Sort.Direction.DESC, "id");
    Pageable pageable = new PageRequest(page, size, sort);
    Page<User> pageBean = userRepository.findAll(pageable);
    model.addAttribute("users", pageBean);
    return "userList";
  }

  @RequestMapping("/notnull")
  @ResponseBody
  public List<User> test() {
    return userRepository.findUsersByUserNameNotNull();
  }
}
