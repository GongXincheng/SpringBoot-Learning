package com.gxc.controller;

import com.gxc.entity.Users;
import com.gxc.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Redis controller .
 * @author 宫新程
 * @date 2018/9/8 14:15
 */
@Controller
public class UserController {

  @Resource
  private UserService userService;

  @RequestMapping("/boot/userList")
  @ResponseBody
  public Object findAllUsers() throws ExecutionException, InterruptedException {
    List<Users> usersList = new ArrayList<>();

    //多线程测试 缓存穿透
    ExecutorService executorService = Executors.newFixedThreadPool(25);
    for (int i = 0; i < 1000; i++) {
      Future<List<Users>> submit = executorService.submit(() -> userService.getAllUsers());
      usersList = submit.get();
    }
    return usersList;
  }

}
