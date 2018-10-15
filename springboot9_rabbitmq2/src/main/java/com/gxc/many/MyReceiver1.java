package com.gxc.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 一对多接收者.
 *
 * @author 宫新程
 * @since 2018/10/14 16:56
 */
@Component
@RabbitListener(queues = "oneToMany1")
public class MyReceiver1 {

  @RabbitHandler
  public void receice(String i) {
    System.out.println(MyReceiver1.class.getSimpleName() + "：" + i);
  }
}
