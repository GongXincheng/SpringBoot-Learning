package com.gxc.hello;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 发送者.
 *
 * @author 宫新程
 * @since 2018/09/25 16:14
 */
@Component
public class HelloSender {

  @Autowired private AmqpTemplate amqpTemplate;

  /** 发送. */
  public void send() {
    String context = "hello " + new Date();
    System.out.println("Sender : " + context);
    amqpTemplate.convertAndSend("hello", context);
  }
}
