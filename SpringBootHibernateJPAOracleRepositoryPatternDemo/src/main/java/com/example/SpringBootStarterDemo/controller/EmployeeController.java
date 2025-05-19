package com.example.SpringBootStarterDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStarterDemo.model.Employee;
import com.example.SpringBootStarterDemo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository _employeeRepository;
	
	@GetMapping
	public List<Employee> getAll() {
		return _employeeRepository.findAll();
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return _employeeRepository.save(employee);
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable int id) {
		return _employeeRepository.findById(id).orElse(null);
	}
	
	@PutMapping
	public Employee update(@RequestBody Employee emp) {
		return _employeeRepository.save(emp);
	}
	
	@PutMapping("/{name}")
	public ResponseEntity<?> updateByName(@PathVariable String name, @RequestBody Employee updatedData) {
	    Optional<Employee> optionalEmp = _employeeRepository.findByName(name);

	    if (optionalEmp.isPresent()) {
	        Employee emp = optionalEmp.get();
	        emp.setEmail(updatedData.getEmail());
	        emp.setSalary(updatedData.getSalary());
	        Employee updated = _employeeRepository.save(emp);
	        return ResponseEntity.ok(updated);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Employee not found with name: " + name);
	    }
	}


	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		_employeeRepository.deleteById(id);
		return "Employee Deleted!";
	}
	
	
	
}
