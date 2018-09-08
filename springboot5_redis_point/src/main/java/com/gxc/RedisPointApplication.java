package com.gxc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gxc.mapper")
public class RedisPointApplication {

  public static void main(String[] args) {
    SpringApplication.run(RedisPointApplication.class, args);
  }
}
