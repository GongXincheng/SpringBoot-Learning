package com.gxc;

import com.gxc.hello.HelloSender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 宫新程
 * @since 2018/09/25 16:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

  @Autowired
  private HelloSender helloSender;

  @Test
  public void testSender() throws InterruptedException {
    this.helloSender.send();
    Thread.sleep(1000L);
  }

}
