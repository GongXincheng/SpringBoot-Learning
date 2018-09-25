package com.gxc.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义队列.
 *
 * @author 宫新程
 * @since 2018/09/25 16:13
 */
@Configuration
public class RabbitConfig {

  @Bean
  public Queue helloQueue() {
    return new Queue("hello");
  }
}
