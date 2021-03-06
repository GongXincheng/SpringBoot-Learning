package com.gxc.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收者2.
 *
 * @author 宫新程
 * @since 2018/09/25 16:46
 */
@Component
@RabbitListener(queues = "gxc")
public class GxcReceiver2 {

  @RabbitHandler
  public void process(String gxc) {
    System.out.println("GxcReceiver2：" + gxc);
  }
}
