package com.gxc;

import com.gxc.dao.UserRepository;
import com.gxc.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author 宫新程
 * @date 2018/9/7 10:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTEST {

  @Autowired
  private UserRepository userRepository;

  @Test
  public void testInsert(){

    for(int i = 0; i < 104; i++){
      User user = new User();
      user.setUserName("admin_" + i);
      user.setPassWord("pwd_$_" + i);
      user.setRegTime(new Date());
      user.setAge(i);

      userRepository.save(user);
    }

  }

}
