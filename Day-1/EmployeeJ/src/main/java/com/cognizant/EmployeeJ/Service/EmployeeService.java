package com.cognizant.EmployeeJ.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.EmployeeJ.model.Employee;
import com.cognizant.EmployeeJ.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public void addEmployee(Employee employee) {

	employeeRepository.save(employee);

	}
}
