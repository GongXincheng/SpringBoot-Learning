package com.gxc;

import com.gxc.entity.User;
import com.gxc.hello.HelloSender;
import com.gxc.many.GxcSender;
import com.gxc.many.GxcSender2;
import com.gxc.object.ObjectSender;
import com.gxc.topic.TopicSender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 宫新程
 * @since 2018/09/25 16:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

  @Autowired private HelloSender helloSender;
  @Resource private GxcSender gxcSender;
  @Resource private GxcSender2 gxcSender2;
  @Resource private ObjectSender objectSender;
  @Resource private TopicSender topicSender;

  @Test // 一对一
  public void testSender() throws InterruptedException {
    this.helloSender.send();
    Thread.sleep(1000L);
  }

  @Test // 一对多
  public void testOneToMany() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      gxcSender.send(i);
    }
    Thread.sleep(10000L);
  }

  @Test // 多对多
  public void testManyToMany() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      gxcSender.send(i);
      gxcSender2.send(i);
    }
    Thread.sleep(10000L);
  }

  @Test // 发送对象
  public void testObject() throws InterruptedException {
    User user = new User("GXC", 28);
    objectSender.send(user);
    Thread.sleep(10000L);
  }

  @Test // Topic
  public void topic1() throws Exception {
    //topicSender.send1(); //两个接收者都能收到
    topicSender.send2(); //只有接收者二能收到
    Thread.sleep(1000l);
  }

}
