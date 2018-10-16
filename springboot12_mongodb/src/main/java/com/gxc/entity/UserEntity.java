package com.gxc.entity;

import java.io.Serializable;

/**
 * @author 宫新程
 * @since 2018/10/15 15:59
 */
public class UserEntity implements Serializable {
  private static final long serialVersionUID = -3258839839160856613L;
  private Long id;
  private String userName;
  private String passWord;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }
}
