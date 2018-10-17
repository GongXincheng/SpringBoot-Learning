package com.gxc;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot14UploadApplication {

  public static void main(String[] args) {
    SpringApplication.run(Springboot14UploadApplication.class, args);
  }

  /**
   * 为了解决上传文件大于10M出现连接重置的问题.
   *
   * @return
   */
  @Bean
  public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
    tomcat.addConnectorCustomizers(
        (TomcatConnectorCustomizer)
            connector -> {
              if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
              }
            });
    return tomcat;
  }
}
