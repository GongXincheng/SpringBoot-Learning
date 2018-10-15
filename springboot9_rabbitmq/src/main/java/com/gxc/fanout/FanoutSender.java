package com.gxc.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * FanoutSender.
 * @author 宫新程
 * @since 2018/09/25 17:55
 */
@Component
public class FanoutSender {

  @Resource
  private AmqpTemplate amqpTemplate;

  public void send() {
    String context = "hi, fanout msg ";
    System.out.println("Sender : " + context);
    amqpTemplate.convertAndSend("fanoutExchange","fanout.A", context);
    amqpTemplate.convertAndSend("fanoutExchange","fanout.B", context);
    amqpTemplate.convertAndSend("fanoutExchange","fanout.C", context);
  }

}
