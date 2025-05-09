package com.example.SpringBootStarterDemo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStarterDemo.model.Product;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	private Map<Integer, Product> productList = new HashMap<>();
	
	// Populate productList initially with some sample products
	@PostConstruct
	public void init() {
		productList.put(1, new Product(1, "Laptop", 60000));
		productList.put(2, new Product(2, "Mobile", 80000));
		productList.put(3, new Product(3, "Headphones", 5000));
		productList.put(4, new Product(4, "Headphones", 5000));
		productList.put(5, new Product(5, "Headphones", 5000));
	}
	
	// Request URL: http://localhost:8080/products/
	@GetMapping("/")
	public String hello() {
		return "Product Management System";
	}
	
	// Request URL: http://localhost:8080/products/all
	@GetMapping("/all")
	public Collection<Product> getAllProducts() {
		return productList.values();
	}
	
	// Request URL: http://localhost:8080/products/1
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		return productList.get(id);
	}
	
	// Request URL: http://localhost:8080/products/add
	// Header: Content-Type: application/json
	// Body: { "id": 6, "name": "Bluetooth Speaker", "price": 45000 }
	@PostMapping("/add")
	public String addProduct(@RequestBody Product product) {
		productList.put(product.getId(), product);
		return "Product Added Successfully!";
	}
	
	// Request URL: http://localhost:8080/products/4
	// Header: Content-Type: application/json
	// Body: { "id": 4, "name": "Bluetooth Mouse", "price": 3000 }
	@PutMapping("{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product product) {
		productList.put(id, product);
		return "Product Updated Successfully!";
	}
	
	@DeleteMapping("{id}")
	public String deleteProduct(@PathVariable int id) {
		productList.remove(id);
		return "Product Deleted Successfully!";
	}

}
