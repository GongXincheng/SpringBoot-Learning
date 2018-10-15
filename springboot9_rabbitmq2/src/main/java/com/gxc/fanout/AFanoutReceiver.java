package com.gxc.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 宫新程
 * @since 2018/10/15 09:00
 */
@Component
@RabbitListener(queues = "A_Queue")
public class AFanoutReceiver {

  @RabbitHandler
  public void receive(String msg) {
    System.out.println("A_Queue：" + msg);
  }

}
