package com.gxc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 宫新程
 * @since 2018/10/15 14:43
 */
@Component
public class Scheduler2Task {

  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(fixedRate = 6000)
  public void reportCurrentTime() {
    System.out.println("现在时间：" + dateFormat.format(new Date()));
  }
}
