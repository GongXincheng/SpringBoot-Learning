package com.gxc.entity;

import java.io.Serializable;

/**
 * 实体类.
 *
 * @author 宫新程
 * @since 2018/09/25 16:58
 */
public class User implements Serializable {

  private String username;
  private Integer age;

  public User(String username, Integer age) {
    this.username = username;
    this.age = age;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" + "username='" + username + '\'' + ", age=" + age + '}';
  }
}
