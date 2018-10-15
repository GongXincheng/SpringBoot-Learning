package com.gxc.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 宫新程
 * @since 2018/10/14 17:46
 */
@Component
@RabbitListener(queues = "topic.messages")
public class ReceiverMessages {

  @RabbitHandler
  public void receiverMessage(String msg) {
    System.out.println(msg);
  }

}
