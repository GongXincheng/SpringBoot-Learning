package com.gxc.service.impl;

import com.gxc.service.MailService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件.
 * @author 宫新程
 * @since 2018/10/15 15:09
 */
@Service
public class MailServiceImpl implements MailService {

  private final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

  // 发件人
  @Value("${mail.fromMail.addr}")
  private String from;

  @Resource private JavaMailSender mailSender;

  @Override
  public void sendSimpleMail(String to, String subject, String content) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(from);
    message.setTo(to);
    message.setSubject(subject);
    message.setText(content);

    try {
      mailSender.send(message);
      logger.info("简单邮件已经发送。");
    } catch (Exception e) {
      logger.error(from + "：发送简单邮件时发生异常！", e);
    }
  }

  @Override
  public void sendHtmlMail(String to, String subject, String content) {
    MimeMessage mimeMessage = mailSender.createMimeMessage();

    try {
      //true表示需要创建一个multipart message
      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
      helper.setFrom(from);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(content, true);
      logger.info("HTML邮件已经发送。");
    } catch (MessagingException e) {
      e.printStackTrace();
      logger.error(from + "：发送HTML邮件时发生异常！", e);
    }
  }
}
