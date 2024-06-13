package org.example.clientapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientConfiguration {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/message")
public String getLaodBalancerResult(){
    return restTemplate.getForObject("http://localhost:9999/Client-Api/message", String.class);
}









}
