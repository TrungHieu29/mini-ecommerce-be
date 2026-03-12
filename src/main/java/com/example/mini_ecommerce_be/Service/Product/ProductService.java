package com.example.mini_ecommerce_be.Service.Product;

import com.example.mini_ecommerce_be.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> getAllProducts(Pageable pageable);
    Product getProductById(Long id);
}