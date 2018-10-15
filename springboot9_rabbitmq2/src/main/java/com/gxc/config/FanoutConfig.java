package com.gxc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Fanout Exchange Demo.
 *
 * @author 宫新程
 * @since 2018/10/15 08:42
 */
@Configuration
public class FanoutConfig {

  // 初始化Queue：A B C
  @Bean
  public Queue A_Queue() {
    return new Queue("A_Queue");
  }

  @Bean
  public Queue B_Queue() {
    return new Queue("B_Queue");
  }

  @Bean
  public Queue C_Queue() {
    return new Queue("C_Queue");
  }

  // 初始化交换机
  @Bean
  public Exchange fanoutExchange() {
    return new FanoutExchange("fanoutExchange");
  }

  // 初始化绑定
  @Bean
  Binding A_Binding(Queue A_Queue, FanoutExchange fanoutExchange) {
    return BindingBuilder.bind(A_Queue).to(fanoutExchange);
  }

  @Bean
  Binding B_Binding(Queue B_Queue, FanoutExchange fanoutExchange) {
    return BindingBuilder.bind(B_Queue).to(fanoutExchange);
  }

  @Bean
  Binding C_Binding(Queue C_Queue, FanoutExchange fanoutExchange) {
    return BindingBuilder.bind(C_Queue).to(fanoutExchange);
  }
}
