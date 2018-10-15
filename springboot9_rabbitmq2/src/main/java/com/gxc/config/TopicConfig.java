package com.gxc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 宫新程
 * @since 2018/10/14 17:34
 */
@Configuration
public class TopicConfig {

  static final String message = "topic.message";
  static final String messages = "topic.messages";

  // 创建队列：Queue:queueMessage
  @Bean
  public Queue queueMessage() {
    return new Queue(TopicConfig.message);
  }
  // 创建队列：Queue:queueMessages
  @Bean
  public Queue queueMessages() {
    return new Queue(TopicConfig.messages);
  }

  // 创建交换机：Exchange:exchange （Topic Exchange）
  @Bean
  public Exchange exchange() {
    return new TopicExchange("exchange_topic");
  }

  // 创建绑定：Binding:bindingExchangeMessage
  @Bean
  public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
    return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
  }
  // 创建绑定：Binding:bindingExchangeMessages
  @Bean
  public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
    return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
  }
}
