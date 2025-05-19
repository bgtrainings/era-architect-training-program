package com.example.SpringBootStarterDemo.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStarterDemo.feign.DepartmentClient;
import com.example.SpringBootStarterDemo.model.Department;
import com.example.SpringBootStarterDemo.model.Employee;
import com.example.SpringBootStarterDemo.model.EmployeeWithDepartment;
import com.example.SpringBootStarterDemo.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeRepository _employeeRepository;
	
	@Autowired
	private DepartmentClient _departmentClient;
	
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

	@DeleteMapping("/{id}")
	public String delete(@PathVariable int id) {
		_employeeRepository.deleteById(id);
		return "Employee Deleted!";
	}
	
	@GetMapping("/with-department")
	public List<EmployeeWithDepartment> getAllWithDepartment() {
		List<Employee> employees = _employeeRepository.findAll();
		return employees.stream()
				.map(emp -> {
					Department dept = _departmentClient.getDepartmentById(emp.getDepartment());
					return new EmployeeWithDepartment(emp, dept);
				}).collect(Collectors.toList());
	}
	
}
