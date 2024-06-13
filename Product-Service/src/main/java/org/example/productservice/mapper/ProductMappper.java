package org.example.productservice.mapper;

import org.example.productservice.DTO.ProductDTO;
import org.example.productservice.model.Product;

public class ProductMappper {
    public Product productDTOtoEntity(ProductDTO productDTO){

        Product product=new Product();
        product.setId(productDTO.getId());
        product.setProduct_name(productDTO.getProduct_name());
        product.setQuantity(productDTO.getQuantity());
        product.setProduct_price(productDTO.getProduct_price());
        return product;
    }



    public static ProductDTO productDTOtoEntity(Product product){
        ProductDTO productDTO=new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setProduct_name(product.getProduct_name());
        productDTO.setQuantity(product.getQuantity());
        productDTO.setProduct_price(product.getProduct_price());
        return productDTO;
    }





}
