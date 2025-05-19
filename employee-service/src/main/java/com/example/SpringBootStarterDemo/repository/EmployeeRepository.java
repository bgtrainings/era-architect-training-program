package com.example.SpringBootStarterDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootStarterDemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
