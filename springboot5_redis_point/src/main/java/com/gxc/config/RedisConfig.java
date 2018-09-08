package com.gxc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.Charset;

/**
 * Redis 的配置.
 * @author 宫新程
 * @date 2018/9/8 13:25
 */
@Configuration
public class RedisConfig {

  /**
   * 配置 RedisTemplate的字符串序列化器.
   * @param redisConnectionFactory RedisConnectionFactory
   * @return RedisTemplate
   */
  @Bean
  public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    //字符串的序列化器
    RedisSerializer redisSerializer = new StringRedisSerializer(Charset.forName("UTF-8"));
    RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setKeySerializer(redisSerializer);
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    return redisTemplate;
  }

}
