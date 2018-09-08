package com.gxc;

import com.gxc.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

/**
 * @author 宫新程
 * @date 2018/9/7 16:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

  @Resource
  private RedisTemplate redisTemplate;

  @Test // Key Value
  public void testRedis(){
    redisTemplate.opsForValue().set("gxc","GongXincheng");
    Object gxc = redisTemplate.opsForValue().get("gxc");
    System.out.println(gxc);
  }

  @Test // Key Bean
  public void testBean(){
    User user = new User("GXC","admin","羁绊");
    ValueOperations<String,User> valueOperations = redisTemplate.opsForValue();
    valueOperations.set("GXC", user);
    User gxc = valueOperations.get("GXC");
    System.out.println("User——————：" + gxc);
  }

  @Test // Key Bean Expire ：设置过期时间
  public void testExpire() throws InterruptedException {
    User user = new User("CQ", "gong", "柴琪");
    ValueOperations<String,Object> valueOperations = redisTemplate.opsForValue();
    valueOperations.set("expire", user, 100, TimeUnit.MILLISECONDS);
    Thread.sleep(10000);

    Boolean expire = redisTemplate.hasKey("expire");
    if(expire){
      System.out.println("暂未过期！");
    } else {
      System.out.println("已过期！");
    }

  }

}
