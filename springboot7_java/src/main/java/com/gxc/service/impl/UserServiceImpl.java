package com.gxc.service.impl;

import com.gxc.service.UserService;

import org.springframework.stereotype.Service;

/**
 * @author 宫新程
 * @date 2018/9/8 23:53
 */
@Service
public class UserServiceImpl implements UserService {

  @Override
  public String sayHi(String name) {
    return "Hi，" + name;
  }
}
