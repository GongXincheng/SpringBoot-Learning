package com.gxc.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 宫新程
 * @since 2018/09/25 17:53
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {

  @RabbitHandler
  public void process(String message) {
    System.out.println("fanout Receiver B: " + message);
  }

}
