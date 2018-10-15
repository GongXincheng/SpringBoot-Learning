package com.gxc.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 一对多发送者.
 * @author 宫新程
 * @since 2018/10/14 16:52
 */
@Component
public class MySender2 {

  @Value("${gxc.rabbitmq.one-to-many-queue}")
  private String oneToMany;

  @Resource private AmqpTemplate amqpTemplate;

  public void send(int num) {
    String msg = "" + num;
    amqpTemplate.convertAndSend(oneToMany, msg);
    System.out.println("消息发送成功！_ " + num);
  }

}
