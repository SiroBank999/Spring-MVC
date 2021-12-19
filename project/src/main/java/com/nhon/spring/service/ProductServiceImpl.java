package com.nhon.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nhon.spring.models.Product;
import com.nhon.spring.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	public Product findById(int id) {
		return this.productRepository.findById(id);
	}

	public void save(Product product) {
		this.productRepository.save(product);
	}

}
