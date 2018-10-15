package com.gxc.sender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 测试消息发送者.
 *
 * @author 宫新程
 * @since 2018/10/14 15:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloSenderTest {

  @Resource HelloSender helloSender;

  @Test
  public void helloSend() throws InterruptedException {
    helloSender.helloSend();
    Thread.sleep(1000L);
  }

}
