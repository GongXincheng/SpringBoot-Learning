package com.gxc;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

  private Logger logger = LoggerFactory.getLogger(RedisApplicationTests.class);

  @Autowired
  public RedisTemplate<Object, Object> redisTemplate;
  @Autowired
  public StringRedisTemplate stringRedisTemplate;

  @Test //【1】测试 redisTemplateTest
  public void redisTemplateTest() {
    ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
    operations.set("username", "GXC");
    String username = (String) operations.get("username");
    Assert.assertEquals("GXC", username);
  }

  @Test //【2】测试 StringRedisTemplateTest
  public void stringRedisTemplateTest() {
    ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
    operations.set("pwd", "admin");
    String pwd = operations.get("pwd");
    Assert.assertEquals("admin", pwd);
  }

  @Test //【3】测试 Expire 过期时间
  public void testExpire() throws InterruptedException {
    ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
    operations.set("Hello", "World", 100, TimeUnit.MILLISECONDS);
    //线程sleep 1秒
    Thread.sleep(1000);
    String hello = (String) operations.get("Hello");
    if(StringUtils.isEmpty(hello)) {
      logger.info("已经被销毁");
    } else {
      logger.info(hello);
    }

  }

}
