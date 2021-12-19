package com.nhon.spring.repository;

import java.util.List;

import com.nhon.spring.models.Product;

public interface ProductRepository {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);
}
