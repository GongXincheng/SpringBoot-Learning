package com.gxc.mutipart;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author 宫新程
 * @date 2018/9/6 16:47
 */
@Configuration
public class DataSourceConfig {

  @Bean
  @Qualifier("primaryDataSource")
  @ConfigurationProperties(prefix = "spring.primary.datasource")
  public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @Qualifier("secondaryDataSource")
  @Primary
  @ConfigurationProperties(prefix = "spring.secondary.datasource")
  public DataSource secondaryDataSource() {
    return DataSourceBuilder.create().build();
  }


}
