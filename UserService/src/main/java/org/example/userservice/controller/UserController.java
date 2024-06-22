package org.example.userservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.userservice.DTO.ProductDTO;
import org.example.userservice.DTO.UserDTO;
import org.example.userservice.configuration.LoadBalancerConfig;
import org.example.userservice.mapper.Mapper;
import org.example.userservice.model.User;
import org.example.userservice.repository.ProductServiceClient;
import org.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    ProductServiceClient productServiceClient;

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
   @CircuitBreaker(name="productservice",fallbackMethod = "userFallback")
    public UserDTO getUserProductRatingData(){
        UserDTO userDTO =new UserDTO();
       ArrayList<ProductDTO> productList = restTemplate.getForObject("http://localhost:5002"+"/productservice"+ "/get-product",ArrayList.class);
        userDTO.setProductList(productList);
        return userDTO;
    }
    public UserDTO userFallback(Exception ex){
        System.out.println("Inside the fallback"+ex.getMessage());
        UserDTO userDTO =new UserDTO();
        userDTO.setName("fallback");
        userDTO.setEmail("fallback@gmail");
        return userDTO;
    }
    @GetMapping("/get-user-product")
    public String getUserProductData() {
//        UserDTO userDTO =new UserDTO();
//        System.out.println("Inside user product data");
//       ArrayList<ProductDTO> productList=productServiceClient.getUsersProducts();
//        userDTO.setProductList(productList);
        String message=productServiceClient.getUsersProducts();
        return message;
    }
}





//microservice setup
//create application microservice
//circuit breaker ,git config,tracing,all funbctionalities unique ways
//docker jenkins all config on git
//