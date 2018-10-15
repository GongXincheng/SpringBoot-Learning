package com.gxc.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 宫新程
 * @since 2018/10/15 09:00
 */
@Component
@RabbitListener(queues = "C_Queue")
public class CFanoutReceiver {

  @RabbitHandler
  public void receive(String msg) {
    System.out.println("C_Queue：" + msg);
  }

}
