package org.example.userservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.userservice.DTO.ProductDTO;
import org.example.userservice.DTO.UserDTO;
import org.example.userservice.mapper.Mapper;
import org.example.userservice.model.User;
import org.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/userservice")
public class UserController {

    @Autowired
   private  UserRepository userRepo;

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostMapping("/save-user")
    public ResponseEntity<?> saveUserData(@RequestBody UserDTO userDTO){
        Mapper mapper=new Mapper();
        User user=mapper.dtoToEntity(userDTO);
        userRepo.save(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/get-user-data")
    public ResponseEntity<List<User>> getUserData(){

        List<User> userList=userRepo.findAll();
      return new ResponseEntity<>(userList,HttpStatus.ACCEPTED);
    }

    @GetMapping("/user-product")
   @CircuitBreaker(name="application-productservice",fallbackMethod = "userFallback")
    public UserDTO getUserProductRatingData(){

        UserDTO userDTO =new UserDTO();
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCTSERVICE");
        String uri = serviceInstance.getUri().toString();
        String contextPath = serviceInstance.getMetadata().get("configPath");
        System.out.println("URI ::"+uri);
        System.out.println("CONTEXTPATH ::"+contextPath);
        ArrayList<ProductDTO> productList = restTemplate.getForObject(uri + contextPath + "/get-product",ArrayList.class);



      //  ServiceInstance serviceInstanceRating=loadBalancerClient.choose("HOTELRATING");
     //   String uriRating = serviceInstanceRating.getUri().toString();
    //    String contextPathRating = serviceInstanceRating.getMetadata().get("configPath");
      //  ArrayList<RatingDTO> ratingList=restTemplate.getForObject(uriRating+contextPathRating+"/get-rating-data",ArrayList.class);
        //   ArrayList<ProductDTO> productList= restTemplate.getForObject("http://localhost:5002/get-products",ArrayList.class);
    //    ArrayList<RatingDTO> ratingList=restTemplate.getForObject("http://localhost:9093/get-rating-data",ArrayList.class);
        userDTO.setProductList(productList);
       //userDTO.setRatingList(ratingList);
        return userDTO;
    }

    public UserDTO userFallback(Exception ex){
        System.out.println("Inside the fallback"+ex.getMessage());
        UserDTO userDTO =new UserDTO();
        userDTO.setName("fallback");
        userDTO.setEmail("fallback@gmail");
        return userDTO;
    }





}








//microservice setup
//create application microservice
//circuit breaker ,git config,tracing,all funbctionalities unique ways
//docker jenkins all config on git
//