package com.gxc.service;

import com.gxc.entity.User;

/**
 * @author 宫新程
 * @date 2018/9/8 16:23
 */
public interface UserService {

  String sayHi(String name);

  User getUser(int id);

}
