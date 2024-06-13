package org.example.productservice.service;

import jakarta.persistence.Id;
import org.example.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductService extends JpaRepository<Product,Id> {




}
