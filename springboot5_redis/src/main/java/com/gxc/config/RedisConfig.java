package com.gxc.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 缓存配置.
 *
 * @author 宫新程
 * @date 2018/9/7 16:29
 */
@Configuration
@EnableCaching
public class RedisConfig {

  @Bean
  public RedisTemplate<Object, Object> redisTemplate(
      RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);

    // 使用Jackson2JsonRedisSerialize 替换默认序列化
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =
        new Jackson2JsonRedisSerializer(Object.class);

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

    jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

    // 设置value的序列化规则和 key的序列化规则
    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    redisTemplate.setKeySerializer(new StringRedisSerializer());

    redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
    redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

    redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
    redisTemplate.setEnableDefaultSerializer(true);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

//    // 解决乱码问题
//    @Bean(name = "redisTemplate")
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//      RedisTemplate<String, String> template = new RedisTemplate<>();
//      RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//      template.setConnectionFactory(factory);
//      // key序列化方式
//      template.setKeySerializer(redisSerializer);
//      // value序列化
//      template.setValueSerializer(redisSerializer);
//      // value hashmap序列化
//      template.setHashValueSerializer(redisSerializer);
//      // key haspmap序列化
//      template.setHashKeySerializer(redisSerializer);
//      return template;
//    }

  //  @Bean
  //  public CacheManager cacheManager(RedisConnectionFactory factory) {
  //    RedisSerializer<String> redisSerializer = new StringRedisSerializer();
  //    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =
  //        new Jackson2JsonRedisSerializer(Object.class);
  //
  //    // 配置序列化
  //    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
  //    RedisCacheConfiguration redisCacheConfiguration =
  //        config
  //            .serializeKeysWith(
  //                RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer))
  //            .serializeValuesWith(
  //                RedisSerializationContext.SerializationPair.fromSerializer(
  //                    jackson2JsonRedisSerializer));
  //
  //    RedisCacheManager cacheManager =
  //        RedisCacheManager.builder(factory).cacheDefaults(redisCacheConfiguration).build();
  //    return cacheManager;
  //  }

  //  /**
  //   * 主键生产策略
  //   * @return
  //   */
  //  @Bean
  //  public KeyGenerator keyGenerator() {
  //    return new KeyGenerator() {
  //      @Override
  //      public Object generate(Object targer, Method method, Object... params) {
  //        StringBuilder sb = new StringBuilder();
  //        sb.append(targer.getClass().getName());
  //        sb.append(method.getName());
  //        for (Object param : params) {
  //          sb.append(param.toString());
  //        }
  //        return sb.toString();
  //      }
  //    };
  //  }

  //  @Bean
  //  public CacheManager cacheManager(RedisTemplate redisTemplate) {
  //    RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
  //    //设置缓存过期时间
  //    //rcm.setDefaultExpiration(60);//秒
  //    return rcm;
  //  }
}
