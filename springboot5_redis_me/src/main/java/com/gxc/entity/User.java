package com.gxc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 实体类.
 * @author 宫新程
 * @since 2018/9/17 10:30
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors
@ToString
public class User {

  private String username;
  private String password;
  private Integer age;

}
