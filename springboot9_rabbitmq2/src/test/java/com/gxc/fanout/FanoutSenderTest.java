package com.gxc.fanout;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 宫新程
 * @since 2018/10/15 09:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FanoutSenderTest {

  @Resource private FanoutSender fanoutSender;

  @Test
  public void sendMessage() throws InterruptedException {
    for(int i = 0; i < 10; i++){
      fanoutSender.sendMessage("发送消息：" + i);
    }

    Thread.sleep(1000L);
  }
}