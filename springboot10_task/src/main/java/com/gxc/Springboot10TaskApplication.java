package com.gxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 定时任务注解
public class Springboot10TaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot10TaskApplication.class, args);
  }
}
