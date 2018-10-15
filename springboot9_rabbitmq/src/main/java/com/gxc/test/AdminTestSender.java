package com.gxc.test;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

/**
 * 使用AmqpAdmin 初始化 MQ.
 *
 * @author 宫新程
 * @since 2018/09/25 18:11
 */
@Component
public class AdminTestSender {
  private Logger logger = LoggerFactory.getLogger(AdminTestSender.class);

  // 交换机的名称
  private static final String MQ_EXCHANGE = "gxc";
  private AmqpAdmin amqpAdmin;
  private AmqpTemplate amqpTemplate;
  @Resource private AmqpAdmin myAmqpAdmin;
  @Resource private AmqpTemplate myAmqpTemplate;

  /** 初始化MQ */
  @PostConstruct
  public void initMq() {
    amqpAdmin = myAmqpAdmin;
    amqpTemplate = myAmqpTemplate;

    // 创建 DirectExchange 交换机
    DirectExchange directExchange = new DirectExchange(MQ_EXCHANGE, true, false);
    amqpAdmin.declareExchange(directExchange);
    logger.info("MQ初始化...");

    // 添加queue的名称
    String[] queueNames = new String[] {"com.gxc.test.gxcQueue"};

    for (String queueName : queueNames) {
      // 创建Queue
      Queue queue = new Queue(queueName, true);
      amqpAdmin.declareQueue(queue);
      logger.info("MQ队列执行...");

      // 将交换机绑定队列
      Binding binding = BindingBuilder.bind(queue).to(directExchange).with(queueName);
      amqpAdmin.declareBinding(binding);
    }
  }

  /** 发送消息. */
  public void sendMessage() {
    this.amqpTemplate.convertAndSend(MQ_EXCHANGE, "com.gxc.test.gxcQueue", "HelloWorld!");
  }
}
