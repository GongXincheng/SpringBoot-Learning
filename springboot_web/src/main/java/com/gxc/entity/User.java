package com.gxc.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 测试Entity类 验证字段
 *
 * @author 宫新程
 * @date 2018/9/6 13:49
 */
public class User {

  @NotNull(message = "用户名不能为空")
  private String username;

  @Length(min = 6, max = 16, message = "密码长度6-16")
  private String password;

  @Max(value = 120)
  @Min(value = 1)
  private int age;

  /**
   * 构造方法
   *
   * @param username 用户名
   * @param password 密码
   * @param age 年龄
   */
  public User(String username, String password, int age) {
    this.username = username;
    this.password = password;
    this.age = age;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{"
        + "username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + ", age="
        + age
        + '}';
  }
}
