package com.cognizant.ormLearn.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormLearn.OrmLearnApplication;
import com.cognizant.ormLearn.Model.Employee;
import com.cognizant.ormLearn.Repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	@Transactional 
	public Employee get(int id) { 
	LOGGER.info("Start"); 
	return employeeRepository.findById(id).get(); 
	} 
	
	@Transactional 
	public void save(Employee employee) { 
	LOGGER.info("Start"); 
	employeeRepository.save(employee); 
	LOGGER.info("End"); 
	}

	public List<Employee> getAllPermanentEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllPermanentEmployees();
	} 
	
	@Transactional
	public Double getAvgSalaryByDepartment(int departmentId) {
		//return employeeRepository.getAverageSalary();
		return employeeRepository.getAverageSalary(departmentId);
	}
	
	@Transactional
	public List<Employee> getAllEmployeeNativeQuery(){
		return employeeRepository.getAllEmployeesNative();
	}
}
