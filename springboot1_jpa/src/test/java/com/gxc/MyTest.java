package com.gxc;

import com.gxc.dao.UserRepository;
import com.gxc.entity.User;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author 宫新程
 * @date 2018/9/6 15:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

  @Autowired private UserRepository userRepository;

  @Test // 添加
  public void testSave() {
    for (int i = 88; i < 100; i++) {
      User user = new User();
      user.setUserName("name_" + i);
      user.setPassWord("pwd_" + (int) (Math.random() * 100000));
      user.setEmail((int) (Math.random() * 10000000) + "@qq.com");
      user.setRegTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
      userRepository.save(user);
    }
  }

  @Test // existsById
  public void testExistsById() {
    boolean flag = userRepository.existsById(10L);
    System.out.println(flag);
  }

  //  @Test //findUserByUserNameLike
  //  public void findUserByUsername(){
  //    List<User> list = this.userRepository.findUserByUserNameLike("%1%");
  //    for (User user : list) {
  //      System.out.println(user.getUserName());
  //    }
  //  }

  @Test // Between 关键字
  public void findByIdBetween() {
    List<User> list = this.userRepository.findByIdBetween(10L, 18L);
    for (User user : list) {
      System.out.println(user);
    }
  }

  @Test // *** In 关键字
  public void findUserByIdIn() {
    List<Long> ids = new ArrayList<>();
    ids.add(28L);
    ids.add(18L);
    ids.add(2L);
    List<User> users = this.userRepository.findUserByIdIn(ids);
    for (User user : users) {
      System.out.println(user);
    }
  }

  @Test // 分页查询
  public void testPage() {
    Pageable pageable = new PageRequest(0, 10, Sort.Direction.ASC, "id");
    Page<User> pageBean = this.userRepository.findUserByUserNameLike("%name%", pageable);
    List<User> content = pageBean.getContent();
    for (User user : content) {
      System.out.println(user.getUserName());
    }
  }

  @Test // 取前15条数据
  public void testTopNumber() {
    List<User> users = this.userRepository.findTop15ByUserNameLike("%name%");
    for (User user : users) {
      System.out.println(user);
    }
  }

  // 动态查询（多条件查询）
  @Test
  public void testSpecificationExecutor(User user) {
    List<User> userList = this.userRepository.findAll(new Specification<User>() {
      @Override
      public Predicate toPredicate(
          Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        Predicate predicate = cb.conjunction();
        if (user != null) {
          if (StringUtils.isNotBlank(user.getUserName())) {
            predicate.getExpressions().add(cb.like(root.get("userName"), user.getUserName()));
          }
        }
        return predicate;
      }
    });

    for (User user1 : userList) {
      System.out.println(user1);
    }
  }
}
