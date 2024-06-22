//package org.example.userservice.configuration;
//
//import org.example.productservice.ProductServiceApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.reactive.function.client.WebClient;
//
//@Configuration
//@LoadBalancerClient(value = "ProductService")
//public class WebClientConfiguration {
//    @Bean
//    @LoadBalanced
//     WebClient.Builder webClient(){
//    return WebClient.builder();
//    }
//}
