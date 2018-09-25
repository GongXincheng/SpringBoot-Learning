package com.gxc.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 发送者.
 *
 * @author 宫新程
 * @since 2018/09/25 16:41
 */
@Component
public class TopicSender {

  @Resource private AmqpTemplate amqpTemplate;

  /** 发送1. */
  public void send1() {
    String context = "hi, i am message 1";
    System.out.println("Sender : " + context);
    amqpTemplate.convertAndSend("exchange", "topic.message", context);
  }

  /** 发送2. */
  public void send2() {
    String context = "hi, i am messages 2";
    System.out.println("Sender : " + context);
    amqpTemplate.convertAndSend("exchange", "topic.messages", context);
  }
}
