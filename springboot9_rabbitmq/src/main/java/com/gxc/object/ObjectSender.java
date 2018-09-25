package com.gxc.object;

import com.gxc.entity.User;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 对象发送者.
 * @author 宫新程
 * @since 2018/09/25 16:57
 */
@Component
public class ObjectSender {

  @Resource
  private AmqpTemplate amqpTemplate;

  //发送者
  public void send(User user) {
    System.out.println("Sender object: " + user.toString());
    amqpTemplate.convertAndSend("object", user);
  }

}
