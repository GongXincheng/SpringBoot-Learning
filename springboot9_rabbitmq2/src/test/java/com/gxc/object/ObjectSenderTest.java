package com.gxc.object;

import static org.junit.Assert.*;

import com.gxc.entity.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 宫新程
 * @since 2018/10/14 17:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectSenderTest {

  @Resource private ObjectSender objectSender;

  @Test
  public void sendObject() throws InterruptedException {
    User user = new User("gxc",1);
    objectSender.sendObject(user);
    Thread.sleep(1000L);
  }
}