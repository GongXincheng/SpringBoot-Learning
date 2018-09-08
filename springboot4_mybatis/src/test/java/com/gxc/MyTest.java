package com.gxc;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxc.entity.UserEntity;
import com.gxc.enums.UserSexEnum;
import com.gxc.mapper.UserMapper;
import com.gxc.param.UserParam;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author 宫新程
 * @date 2018/9/7 14:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

  @Resource private UserMapper userMapper;

  @Test
  public void test1() {
    for (int i = 0; i < 104; i++) {
      UserEntity user = new UserEntity();
      user.setUserName("admin_" + i);
      user.setPassWord("pwd_$_" + i);
      user.setNickName("nick_***_" + i);
      user.setUserSex(i % 2 == 0 ? UserSexEnum.MAN : UserSexEnum.MAN);
      userMapper.insert(user);
    }
  }

  @Test // 测试注解式：查询全部
  public void userListByAnno() {
    List<UserEntity> userList = this.userMapper.getAllByAnno();
    for (UserEntity userEntity : userList) {
      System.out.println(userEntity);
    }
  }

  @Test // 条件查询
  public void testById() {
    UserEntity user = this.userMapper.getUserByIdAndAnno(20L);
    System.out.println(user);
  }

  @Test //PageHelper分页
  public void testPageHelper(){
    PageHelper.startPage(1,10);
    List<UserEntity> userList = this.userMapper.getAll();
    PageInfo<UserEntity> pageInfo = new PageInfo<>(userList);
    long total = pageInfo.getTotal();
    System.out.println("总记录数为：" + total);

    for (UserEntity userEntity : userList) {
      System.out.println(userEntity);
    }
  }

  @Test //使用SqlClass的方式：方式一
  public void testPageBySqlClass(){
    UserParam userParam = new UserParam();
    userParam.setUserName("%1%");
    userParam.setCurrentPage(0);
    userParam.setPageSize(3);
    List<UserEntity> allUserBySqlClass = this.userMapper.getAllUserBySqlClass(userParam);
    for (UserEntity userBySqlClass : allUserBySqlClass) {
      System.out.println(userBySqlClass);
    }
  }


  @Test //使用SqlClass的方式：方式2
  public void testPageBySqlClass2(){
    UserParam userParam = new UserParam();
    userParam.setUserName("%1%");
    userParam.setCurrentPage(0);
    userParam.setPageSize(3);
    List<UserEntity> allUserBySqlClass = this.userMapper.getAllUserBySqlClass2(userParam);
    for (UserEntity userBySqlClass : allUserBySqlClass) {
      System.out.println(userBySqlClass);
    }
  }
}
