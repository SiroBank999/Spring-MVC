package com.nhon.spring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nhon.spring.models.Product;



public class ProductRepositoryImpl implements ProductRepository {

	private static final Map<Integer, Product> products;

    static {
        products = new HashMap<Integer, Product>();
        products.put(1, new Product(1, "GTFS", "Fender Stratocaster", 1200));
        products.put(2, new Product(2, "GTFT", "Fender Telecaster", 1400));
        products.put(3, new Product(3, "GTLP", "Gibson Les Paul", 2200));
        products.put(4, new Product(4, "GTGS", "Gibson SG", 1410));
        products.put(5, new Product(5, "GTFV", "Gibson Flying V", 13200));
        products.put(6, new Product(6, "GTSS", "Superstrat", 4200));
    }

	public List<Product> findAll() {
		 return new ArrayList<Product>(products.values());
	}

	public Product findById(int id) {
		Product product = products.get(id);
        return product;
	}
	
	public void save(Product product) {
		int id = findAll().size();
		product.setId(id);
		products.put(id + 1, product);
		
	}

	public void removeById(int id) {
		products.remove(id);
		
	}

	public void update(Product product) {
		products.replace(product.getId(), product);
		
	}
}
