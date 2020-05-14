package com.cognizant.EmployeeJ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.EmployeeJ.Service.EmployeeService;
import com.cognizant.EmployeeJ.model.Employee;


@SpringBootApplication
public class EmployeeJApplication {
	public static EmployeeService employeeService;
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeeJApplication.class, args);
		employeeService = context.getBean(EmployeeService.class);
		Employee employee=new Employee();
		employee.setEid(7);
		employee.setFirstName("Ha");
		employee.setLastName("Deep");
		employee.setSalary(20000);
		employeeService.addEmployee(employee);
	}

}
