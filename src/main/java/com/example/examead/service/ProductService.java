package com.example.examead.service;

import com.example.examead.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product sellProduct(Long id, Integer quantity);
    List<Product> findAll();
    Product findById(Long id);
}
