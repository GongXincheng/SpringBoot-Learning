package com.gxc.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 宫新程
 * @since 2018/10/14 17:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTopicSenderTest {

  @Autowired
  private MyTopicSender myTopicSender;

  @Test
  public void send1() {
    myTopicSender.send1();
  }

  @Test
  public void send2() {
    myTopicSender.send2();
  }
}