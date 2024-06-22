package org.example.productservice.controller;
import org.example.productservice.DTO.ProductDTO;
import org.example.productservice.mapper.ProductMappper;
import org.example.productservice.model.Product;
import org.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productservice")
public class ProductController {

    @Autowired
    ProductService productService;
    @PostMapping("/save-product")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO productDTO){
        ProductMappper productMappper=new ProductMappper();
        Product product=productMappper.productDTOtoEntity(productDTO);
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/get-product")
    public ResponseEntity<?> getAllProduct(){
        System.out.println("inside product");
        List<Product> productList=productService.findAll();
       List<ProductDTO> productListDTO= productList.stream().map(ProductMappper::productDTOtoEntity).collect(Collectors.toList());
        return new ResponseEntity<>(productListDTO,HttpStatus.CREATED);

    }
    @GetMapping("/get-user-product")
    public String getUsersProducts(){

        return "Hello user product";
    }


}
