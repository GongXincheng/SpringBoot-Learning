package com.gxc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TopicRabbitConfig .
 *
 * @author 宫新程
 * @since 2018/09/25 17:06
 */
@Configuration
public class TopicRabbitConfig {

  private static final String message = "topic.message";
  private static final String messages = "topic.messages";

  // 定义队列
  @Bean
  public Queue queueMessage() {
    return new Queue(TopicRabbitConfig.message);
  }

  @Bean
  public Queue queueMessages() {
    return new Queue(TopicRabbitConfig.messages);
  }

  // 交换机
  @Bean
  public TopicExchange exchange() {
    return new TopicExchange("exchange");
  }

  // 将队列和交换机绑定
  // 设计 queueMessages 同时匹配两个队列，queueMessage 只匹配“topic.message”队列。
  @Bean
  public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
    return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
  }

  @Bean
  public Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
    return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
  }
}
