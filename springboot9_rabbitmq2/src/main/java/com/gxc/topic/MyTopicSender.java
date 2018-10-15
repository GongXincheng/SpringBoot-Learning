package com.gxc.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 宫新程
 * @since 2018/10/14 17:44
 */
@Component
public class MyTopicSender {

  @Resource private AmqpTemplate amqpTemplate;

  public void send1() {
    String context = "hi, i am message 1";
    this.amqpTemplate.convertAndSend("exchange", "topic.message", context);
  }

  public void send2() {
    String context = "hi, i am message ssssssssssssss";
    this.amqpTemplate.convertAndSend("exchange", "topic.messages", context);
  }
}
