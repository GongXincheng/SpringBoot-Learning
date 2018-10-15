package com.gxc.service;

/**
 * @author 宫新程
 * @since 2018/10/15 15:08
 */
public interface MailService {

  /**
   * 发送 普通 邮箱.
   * @param to
   * @param subject
   * @param content
   */
  void sendSimpleMail(String to, String subject, String content);

  /**
   * 发送 html 邮箱
   * @param to 收件人
   * @param subject 主题
   * @param content 内容
   */
  void sendHtmlMail(String to, String subject, String content);
}
