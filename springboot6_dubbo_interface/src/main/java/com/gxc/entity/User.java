package com.gxc.entity;

import java.io.Serializable;

/**
 * 实体类.
 * @author 宫新程
 * @date 2018/9/8 16:25
 */
public class User implements Serializable {

  private int id;
  private String name;
  private String phone;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
