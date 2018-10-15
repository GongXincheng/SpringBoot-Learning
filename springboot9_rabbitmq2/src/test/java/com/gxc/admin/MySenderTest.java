package com.gxc.admin;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 宫新程
 * @since 2018/10/15 09:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MySenderTest {

  @Autowired
  private MySender mySender;

  @Test
  public void sendMessage() {
    for(int i = 0; i < 5; i++) {
      mySender.sendMessage(i + "");
    }
  }
}