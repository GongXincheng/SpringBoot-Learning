package com.gxc.many;

import javax.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * 发送者：一对多.
 * @author 宫新程
 * @since 2018/09/25 16:43
 */
@Component
public class GxcSender {

  @Resource
  private AmqpTemplate amqpTemplate;

  /** 发送者. */
  public void send(int i) {
    String context = "spirng boot gxc queue" + " ****** " + i;
    System.out.println("Sender1 : " + context);
    amqpTemplate.convertAndSend("gxc", context);
  }

}
