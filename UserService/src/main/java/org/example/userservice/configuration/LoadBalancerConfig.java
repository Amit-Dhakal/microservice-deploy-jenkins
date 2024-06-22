package org.example.userservice.configuration;
import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
@LoadBalancerClient(value="PRODUCTSERVICE")
public class LoadBalancerConfig {
    @Bean
    @LoadBalanced
    public Feign.Builder feignBuilder(){
        return Feign.builder();
    }
    @Bean
    public static RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
