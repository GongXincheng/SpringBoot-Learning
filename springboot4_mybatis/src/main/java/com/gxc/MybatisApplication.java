package com.gxc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.gxc.mapper")
@EnableTransactionManagement //事物注解
public class MybatisApplication {

  public static void main(String[] args) {
    SpringApplication.run(MybatisApplication.class, args);
  }
}
