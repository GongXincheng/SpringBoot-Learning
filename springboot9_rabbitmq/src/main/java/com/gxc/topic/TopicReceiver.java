package com.gxc.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接受者.
 * @author 宫新程
 * @since 2018/09/25 17:14
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver {

  @RabbitHandler
  public void process(String message) {
    System.out.println("Topic Receiver1  : " + message);
  }


}
