package com.gxc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Springboot2ThymeleafPointApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot2ThymeleafPointApplication.class, args);
  }
}
