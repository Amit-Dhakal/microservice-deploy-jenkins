package org.example.userservice.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(value = "PRODUCTSERVICE",url="http://localhost:5002/productservice")
public interface ProductServiceClient {
    @GetMapping("/get-user-product")
    String getUsersProducts();

}
