package com.gxc.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消息发送者.
 *
 * @author 宫新程
 * @since 2018/10/15 08:55
 */
@Component
public class FanoutSender {

  @Resource private AmqpTemplate amqpTemplate;

  public void sendMessage(String msg) {
    amqpTemplate.convertAndSend("fanoutExchange", "", msg);
  }
}
