package com.example.SpringBootStarterDemo.service;

import java.util.List;

import com.example.SpringBootStarterDemo.model.Product;

public interface ProductService {

	List<Product> getAllProducts();
	Product getProductById(int id);
	void addProduct(Product product);
	void deleteProduct(int id);
	
}
