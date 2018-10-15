package com.gxc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 初始化 Queue .
 *
 * @author 宫新程
 * @since 2018/10/14 15:16
 */
@Configuration
public class QueueConfig {

  private static final Logger logger = LoggerFactory.getLogger(QueueConfig.class);

  @Value("${gxc.rabbitmq.hello-queue}")
  private String queueName;

  @Value("${gxc.rabbitmq.one-to-many-queue}")
  private String oneToMany;

  @Value("${gxc.rabbitmq.gxc1}")
  private String gxc1;

  @Value("${gxc.rabbitmq.object}")
  private String object;

  @Bean
  public Queue queue() {
    logger.info("初始化：{} Queue成功！", queueName);
    return new Queue(queueName);
  }

  @Bean
  public Queue oneToManyQueue() {
    logger.info("初始化：{} Queue成功！", oneToMany);
    return new Queue(oneToMany);
  }

  @Bean
  public Queue gxc1() {
    logger.info("初始化：{} Queue成功！", gxc1);
    return new Queue(gxc1);
  }

  @Bean
  public Queue object1() {
    logger.info("初始化：{} Queue成功！", object);
    return new Queue(object);
  }
}
