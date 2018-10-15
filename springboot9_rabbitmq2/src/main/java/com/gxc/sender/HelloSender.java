package com.gxc.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消息发送者.
 *
 * @author 宫新程
 * @since 2018/10/14 15:18
 */
@Component
public class HelloSender {

  private static final Logger logger = LoggerFactory.getLogger(HelloSender.class);

  @Value("${gxc.rabbitmq.hello-queue}")
  private String queueName;

  @Resource AmqpTemplate amqpTemplate;

  /**
   * 发送消息.
   */
  public void helloSend() {
    String context = "Hello World !";
    logger.info("消息发送成功：{}", this.getClass().getName());
    amqpTemplate.convertAndSend(queueName, context);
  }
}
