package com.gx;

import de.codecentric.boot.admin.config.EnableAdminServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class Springboot16AdminServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot16AdminServerApplication.class, args);
  }
}
