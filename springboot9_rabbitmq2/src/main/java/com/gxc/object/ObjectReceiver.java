package com.gxc.object;

import com.gxc.entity.User;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 宫新程
 * @since 2018/10/14 17:26
 */
@Component
@RabbitListener(queues = "object1")
public class ObjectReceiver {

  @RabbitHandler
  public void receiveObject(User user) {
    System.out.println("接收者接收：" + user);
  }
}
