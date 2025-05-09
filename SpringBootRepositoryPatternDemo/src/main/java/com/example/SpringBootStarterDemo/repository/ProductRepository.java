package com.example.SpringBootStarterDemo.repository;

import java.util.List;

import com.example.SpringBootStarterDemo.model.Product;

public interface ProductRepository {

	List<Product> findAll();
	Product findById(int id);
	void save(Product product);
	void deleteById(int id);
	
}
