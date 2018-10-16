package com.gxc.dao;

import static org.junit.Assert.*;

import com.gxc.entity.UserEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 宫新程
 * @since 2018/10/15 16:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoImplTest {

  @Autowired
  private UserDaoImpl userDao;

  @Test
  public void saveUser() {
    UserEntity user = new UserEntity();
    user.setId(1L);
    user.setUserName("xgc");
    user.setPassWord("admin");
    userDao.saveUser(user);
  }

  @Test
  public void findUserByUserName() {}

  @Test
  public void updateUser() {}

  @Test
  public void deleteUserById() {}
}