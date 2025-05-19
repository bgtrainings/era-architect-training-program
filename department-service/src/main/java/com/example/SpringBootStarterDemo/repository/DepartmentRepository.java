package com.example.SpringBootStarterDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBootStarterDemo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
