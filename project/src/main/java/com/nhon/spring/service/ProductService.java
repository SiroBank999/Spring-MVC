package com.nhon.spring.service;

import java.util.List;

import com.nhon.spring.models.Product;

public interface ProductService {
	  List<Product> findAll();
	  Product findById(int id);
	  void save(Product product);
	  void removeById(int id);
	  void update(Product product);
}
