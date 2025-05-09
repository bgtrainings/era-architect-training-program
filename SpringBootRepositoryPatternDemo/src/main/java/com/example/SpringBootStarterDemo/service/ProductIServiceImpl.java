package com.example.SpringBootStarterDemo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.SpringBootStarterDemo.model.Product;
import com.example.SpringBootStarterDemo.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductIServiceImpl implements ProductService, ProductRepository {

	private final Map<Integer, Product> productList = new HashMap<>();
	
	// Populate productList initially with some sample products
	@PostConstruct
	public void init() {
		productList.put(1, new Product(1, "Laptop", 60000));
		productList.put(2, new Product(2, "Mobile", 80000));
		productList.put(3, new Product(3, "Headphones", 5000));
		productList.put(4, new Product(4, "Headphones", 5000));
		productList.put(5, new Product(5, "Headphones", 5000));
	}
	
	@Override
	public List<Product> findAll() {
		return new ArrayList<Product>(productList.values());
	}

	@Override
	public Product findById(int id) {
		return productList.get(id);
	}

	@Override
	public void save(Product product) {
		productList.put(product.getId(), product);
		
	}

	@Override
	public void deleteById(int id) {
		productList.remove(id);
		
	}

	// Service Layer Method
	
	@Override
	public List<Product> getAllProducts() {
		return findAll();
	}
	

	@Override
	public Product getProductById(int id) {
		return findById(id);
	}

	@Override
	public void addProduct(Product product) {
		save(product);
		
	}

	@Override
	public void deleteProduct(int id) {
		deleteById(id);
		
	}

}
