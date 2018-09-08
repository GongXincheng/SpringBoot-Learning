package com.gxc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 宫新程
 * @date 2018/9/8 11:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

  @Resource
  private RedisTemplate<Object,Object> redisTemplate;

  @Test
  public void testRedis(){
//    //字符串的序列化器
//    RedisSerializer redisSerializer = new StringRedisSerializer();
//    redisTemplate.setKeySerializer(redisSerializer);

    ValueOperations<Object, Object> operations = this.redisTemplate.opsForValue();
    operations.set("HHH","HHHHHHHHHHHH");
    Object hhh = operations.get("HHH");
    System.out.println(hhh);
  }

}
