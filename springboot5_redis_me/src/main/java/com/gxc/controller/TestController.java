package com.gxc.controller;

import com.gxc.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Test Debug.
 * @author 宫新程
 * @since 2018/9/17 10:07
 */
@Controller
public class TestController {

  private Logger logger = LoggerFactory.getLogger(TestController.class);

  @Resource
  public RedisTemplate<Object,Object> redisTemplate;

  /**
   * 测试.
   * @return String.
   */
  @GetMapping("/test")
  @ResponseBody
  public String test() {
    ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
    String username = (String) operations.get("username");
    logger.debug("username：{}", username);
    return username;
  }

  /**
   * 测试.
   * @return String.
   */
  @GetMapping("/redis")
  @ResponseBody
  public String redisBean() {
    ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
    User user = new User("gxc", "admin", 23);
    operations.set("user", user.toString());

    String userBean = (String) operations.get("user");
    logger.debug("user：{}", userBean);
    return userBean;
  }

}
