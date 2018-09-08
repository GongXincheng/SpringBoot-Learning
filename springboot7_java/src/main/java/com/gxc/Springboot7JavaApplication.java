package com.gxc;

import static org.springframework.boot.Banner.Mode.OFF;

import com.gxc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot7JavaApplication implements CommandLineRunner {

  @Autowired
  private UserService userService;

  public static void main(String[] args) {
    //方式二： 
    // 返回Spring容器对象
//    ConfigurableApplicationContext context =
//        SpringApplication.run(Springboot7JavaApplication.class, args);
//    UserService userService = (UserService) context.getBean("userServiceImpl");
//    String str = userService.sayHi("SpringBoot java");
//    System.out.println(str);

    //关闭 SpringBoot的 Log
    SpringApplication springApplication = new SpringApplication(Springboot7JavaApplication.class);
    springApplication.setBannerMode(Banner.Mode.OFF);
    springApplication.run(args);
  }

  /**
   * 方式一：相当于纯java的main方法
   * @param args
   * @throws Exception
   */
  @Override
  public void run(String... args) throws Exception {
    String springBoot = userService.sayHi("SpringBoot");
    System.out.println(springBoot);
  }
}
