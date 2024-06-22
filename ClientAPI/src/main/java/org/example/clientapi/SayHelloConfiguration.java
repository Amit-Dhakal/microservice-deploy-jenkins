package org.example.clientapi;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
/**
 * @author Olga Maciaszek-Sharma
 */
@Configuration
public class SayHelloConfiguration {
  @Bean
  @Primary
  ServiceInstanceListSupplier serviceInstanceListSupplier() {
    return new DemoServiceInstanceListSuppler("say-hello");
  }

}