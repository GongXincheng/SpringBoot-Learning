package com.gxc.admin;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 宫新程
 * @since 2018/10/14 16:56
 */
@Component("MyReceiver1_1")
//@RabbitListener(queues = "adminQueue_1")
public class MyReceiver1 {

  //@RabbitHandler
  public void receice(String i) {
    System.out.println(MyReceiver1.class.getSimpleName() + "：" + i);
  }
}
