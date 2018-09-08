package com.gxc.controller;

import com.gxc.entity.UserEntity;
import com.gxc.mapper.UserMapper;
import com.gxc.param.UserParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author 宫新程
 * @date 2018/9/7 13:53
 */
@Controller
public class UserController {

  @Resource private UserMapper userMapper;


  /**
   * 测试查询数据
   * @return
   */
  @RequestMapping("/test")
  @ResponseBody
  public List<UserEntity> test() {
    UserParam userParamter = new UserParam();
    userParamter.setUserName("%1%");
    List<UserEntity> userList = this.userMapper.getAllUserBySqlClass2(userParamter);
    return userList;
  }
}
