package com.gxc.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

/**
 * @author 宫新程
 * @since 2018/10/15 09:50
 */
@Component
public class MyAdminReceiver {

  private static final Logger log = LoggerFactory.getLogger(MyAdminReceiver.class);
  @Autowired private ConnectionFactory connectionFactory;

  @PostConstruct
  private void postConstruct() {

    log.info("接收者初始化ing ....");

    // 创建 Queue 和 方法名 的映射关系  -> queueName:methodName
    Map<String, String> methodNameMap = new HashMap<>();
    methodNameMap.put("adminQueue_1", "updateAll1");
    methodNameMap.put("adminQueue_2", "updateAll2");

    // Queue 名称
    String[] queueArr = new String[] {"adminQueue_1", "adminQueue_2"};

    for (String str : queueArr) {
      // 初始化MessageListenerAdapter
      MessageListenerAdapter adapter = new MessageListenerAdapter(this);
      adapter.setDefaultListenerMethod(methodNameMap.get(str));

      // SimpleMessageListenerContainer
      SimpleMessageListenerContainer container =
          new SimpleMessageListenerContainer(connectionFactory);
      container.setDefaultRequeueRejected(false);
      container.setMessageListener(adapter);
      container.setQueueNames(str);
      container.start();
    }
  }

  public void updateAll1(String msg) {
    System.out.println("updateAll_1：" + msg);
  }

  public void updateAll2(String msg) {
    System.out.println("updateAll_2：" + msg);
  }
}
