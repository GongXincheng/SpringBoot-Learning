package com.gxc.object;

import com.gxc.entity.User;

import javax.annotation.Resource;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 测试发送对象.
 * @author 宫新程
 * @since 2018/10/14 17:23
 */
@Component
public class ObjectSender {

  @Value("${gxc.rabbitmq.object}")
  private String object;

  @Resource private AmqpTemplate amqpTemplate;

  public void sendObject(User user) {
    amqpTemplate.convertAndSend(object, user);
    System.out.println("消息发送成功：" + user.toString());
  }
}
