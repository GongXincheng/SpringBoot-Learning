package com.gxc.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 宫新程
 * @since 2018/10/15 14:42
 */
@Component
public class SchedulerTask {

  private int count = 0;

  @Scheduled(cron = "*/6 * * * * ?")
  private void process() {
    System.out.println("this is scheduler task runing  " + (count++));
  }
}
