package com.gxc.object;

import com.gxc.entity.User;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 对象 接收者.
 * @author 宫新程
 * @since 2018/09/25 17:00
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

  //接收者
  @RabbitHandler
  public void process(User user) {
    System.out.println("Receiver object : " + user);
  }

}
