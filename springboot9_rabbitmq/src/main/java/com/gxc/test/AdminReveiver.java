package com.gxc.test;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收者.
 * @author 宫新程
 * @since 2018/09/25 18:23
 */
@Component
@RabbitListener(queues = "com.gxc.test.gxcQueue")
public class AdminReveiver {

  @RabbitHandler
  public void receiver(String msg) {
    System.out.println(msg);
  }
}
