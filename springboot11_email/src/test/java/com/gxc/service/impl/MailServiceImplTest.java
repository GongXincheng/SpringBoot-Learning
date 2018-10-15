package com.gxc.service.impl;

import com.gxc.service.MailService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 宫新程
 * @since 2018/10/15 15:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

  @Autowired private MailService mailService;

  @Test
  public void sendSimpleMail() {
    mailService.sendSimpleMail(
        "gongxincheng@jsh.com", "test simple mail", " hello this is simple mail");
  }

  @Test
  public void sendHtmlMail() {
    String content =
        "<html>\n"
            + "<body>\n"
            + "    <h3>hello world ! 这是一封Html邮件!</h3>\n"
            + "</body>\n"
            + "</html>";
    mailService.sendHtmlMail("gongxincheng@jsh.com", "html", content);
  }
}
