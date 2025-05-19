package com.example.SpringBootStarterDemo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.SpringBootStarterDemo.model.Department;

@FeignClient(name = "department-service", url = "http://localhost:8082")
public interface DepartmentClient {

	@GetMapping("/api/departments/{id}")
	Department getDepartmentById(@PathVariable("id") int id);
	
}
