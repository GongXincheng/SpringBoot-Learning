package com.gxc.many;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 宫新程
 * @since 2018/10/14 16:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MySender1Test {

  @Autowired private MySender1 mySender1;
  @Autowired private MySender2 mySender2;

  @Test
  public void send() throws InterruptedException {
    for(int i = 0; i < 10; i++){
      mySender1.send(i);
    }
    Thread.sleep(1000L);
  }

  @Test
  public void send2() throws InterruptedException {
    for(int i = 0; i < 10; i++){
      mySender1.send(i);
      mySender2.send(i);
    }
    Thread.sleep(1000L);
  }
}