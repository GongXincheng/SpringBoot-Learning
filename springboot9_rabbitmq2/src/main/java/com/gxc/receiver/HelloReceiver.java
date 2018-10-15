package com.gxc.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者.
 *
 * @author 宫新程
 * @since 2018/10/14 15:27
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

  @RabbitHandler
  public void process(String hello) {
    System.out.println("接收消息：" + hello);
  }

}
