package com.example.SpringBootStarterDemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStarterDemo.model.Department;
import com.example.SpringBootStarterDemo.repository.DepartmentRepository;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired
	private DepartmentRepository _deptRepository;
	
	@GetMapping
	public List<Department> getAll() {
		return _deptRepository.findAll();
	}
	
	@PostMapping
	public Department addEmployee(@RequestBody Department employee) {
		return _deptRepository.save(employee);
	}
	
	@GetMapping("/{id}")
	public Department getById(@PathVariable int id) {
		return _deptRepository.findById(id).orElse(null);
	}
	
	@PutMapping
	public Department update(@RequestBody Department emp) {
		return _deptRepository.save(emp);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		_deptRepository.deleteById(id);
		return "Employee Deleted!";
	}
	
	
	
}
