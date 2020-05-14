package com.cognizant.EmployeeJ.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.EmployeeJ.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
}