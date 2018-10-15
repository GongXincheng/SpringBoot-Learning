package com.gxc.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author 宫新程
 * @since 2018/10/15 09:16
 */
@Component
public class MySender {

  private static final Logger log = LoggerFactory.getLogger(MySender.class);

  @Autowired private AmqpAdmin amqpAdmin;
  @Autowired private AmqpTemplate amqpTemplate;

  @PostConstruct
  public void init() {
    // 初始化 交换机
    DirectExchange directExchange = new DirectExchange("testExchange");
    amqpAdmin.declareExchange(directExchange);

    String[] queueArr = new String[] {"adminQueue_1", "adminQueue_2"};
    for (String str : queueArr) {
      // 初始化 Queue
      Queue queue = new Queue(str);
      amqpAdmin.declareQueue(queue);
      log.info("Queue：{} 初始化成功", str);

      // 初始化 Binding
      Binding binding = BindingBuilder.bind(queue).to(directExchange).with(str);
      amqpAdmin.declareBinding(binding);
    }
  }

  /**
   * 发送消息.
   * @param msg
   */
  public void sendMessage(String msg) {
    amqpTemplate.convertAndSend("adminQueue_1", msg);
    amqpTemplate.convertAndSend("adminQueue_2", msg);
  }
}
