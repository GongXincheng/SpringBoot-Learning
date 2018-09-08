package com.gxc;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration //开启dubbo的自动配置
public class Springboot6DubboProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot6DubboProviderApplication.class, args);
  }
}
