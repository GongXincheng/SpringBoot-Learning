package com.gxc.admin;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 宫新程
 * @since 2018/10/14 16:56
 */
@Component("MyReceiver2_1")
//@RabbitListener(queues = "adminQueue_2")
public class MyReceiver2 {

  //@RabbitHandler
  public void receice(String i) {
    System.out.println(MyReceiver2.class.getSimpleName() + "：" + i);
  }
}
