package com.cognizant.ormLearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormLearn.Model.Department;
import com.cognizant.ormLearn.Model.Employee;
import com.cognizant.ormLearn.Model.Skill;
import com.cognizant.ormLearn.Model.Stock;
import com.cognizant.ormLearn.Service.DepartmentService;
import com.cognizant.ormLearn.Service.EmployeeService;
import com.cognizant.ormLearn.Service.SkillService;
import com.cognizant.ormLearn.Service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	
	
	public static StockService stockService;
	public static EmployeeService employeeService;
	public static DepartmentService departmentService;
	public  static SkillService skillService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		stockService = context.getBean(StockService.class);
		employeeService=context.getBean(EmployeeService.class);
		departmentService=context.getBean(DepartmentService.class);
		skillService=context.getBean(SkillService.class);
		/*testGetAllStocks();
		testGetStockOfSept19();
		testGetGoogleGreaterPrice();
		testTop3Volume();
		testLowest3NetfilxStockDate();*/
	//testGetEmployee();
		//testAddEmployee();
		//testUpdateEmployee();
		//testGetDepartment();
		//testAddSkillToEmployee();
		//testGetAllPermanentEmployees();
		//testGetAverageSalary();
		testGetAllEmployeeNative();
	}
	
	private static void testGetAllEmployeeNative() {
		LOGGER.info("Start"); 
		List<Employee> employeeList=employeeService.getAllEmployeeNativeQuery();
		LOGGER.debug("Employee:{}",employeeList);
		LOGGER.info("End"); 
		
	}

	private static void testGetAverageSalary() {
		LOGGER.info("Start"); 
		//Double averageSalary = employeeService.getAvgSalaryByDepartment(); 
		Double averageSalary = employeeService.getAvgSalaryByDepartment(1);
		System.out.println(averageSalary);		
		LOGGER.info("End"); 
		
	}

	public static void testGetAllPermanentEmployees() { 
		LOGGER.info("Start"); 
		List<Employee> employees = employeeService.getAllPermanentEmployees(); 
		LOGGER.debug("Permanent Employees:{}", employees); 
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList())); 
		LOGGER.info("End"); 
		}
	private static void testAddSkillToEmployee() {
		LOGGER.info("Start"); 
		Employee employee=employeeService.get(4);
		Skill skill=skillService.get(2);
		Set<Skill> skillListSet=employee.getSkillList();
		skillListSet.add(skill);
		employee.setSkillList(skillListSet);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee); 
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList()); 
		LOGGER.info("End");
	}
	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department department=departmentService.get(2);		
		Set<Employee> employeeSet=department.getEmployeeList();
		LOGGER.debug("Department:{}", department); 
		LOGGER.debug("Employee:{}", employeeSet); 
		LOGGER.info("End"); 

		
	}
	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Employee employee=employeeService.get(5);
		Department dept=departmentService.get(2);
		employee.setDepartment(dept);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee); 
		LOGGER.info("End"); 

		
	}
	private static void testAddEmployee() throws ParseException {
		LOGGER.info("Start");
		Employee employee=new Employee();
		employee.setName("XX");
		employee.setPermanent(true);
		employee.setSalary(15000);
		employee.setDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1997-02-19"));
		Department dept=departmentService.get(1);
		employee.setDepartment(dept);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee); 
		LOGGER.info("End"); 

		
	}
	private static void testGetEmployee() { 
		LOGGER.info("Start"); 
		Employee employee = employeeService.get(1); 
		LOGGER.debug("Employee:{}", employee); 
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList()); 
		LOGGER.info("End"); 
		}
	private static void testLowest3NetfilxStockDate() {
		// TODO Auto-generated method stub
		LOGGER.info("Start");
		List<Stock> stocks = stockService.getLowestNetflixStockDate();		
		for (Stock s : stocks) {			
			System.out.println(s.getCode()+";"+s.getDate()+";"+s.getOpen()+";"+s.getClose()+";"+s.getVolume());
		}
		LOGGER.info("End");
	}

	private static void testTop3Volume() {
		
		LOGGER.info("Start");
		List<Stock> stocks = stockService.getTopThreeByVolume();		
		for (Stock s : stocks) {			
			System.out.println(s.getCode()+";"+s.getDate()+";"+s.getOpen()+";"+s.getClose()+";"+s.getVolume());
		}
		LOGGER.info("End");
		
	}

	private static void testGetGoogleGreaterPrice() {
		
		LOGGER.info("Start");
		List<Stock> stocks = stockService.getGoggleGreaterPrice();		
		for (Stock s : stocks) {			
			System.out.println(s.getCode()+";"+s.getDate()+";"+s.getOpen()+";"+s.getClose()+";"+s.getVolume());
		}
		LOGGER.info("End");
	}

	private static void testGetStockOfSept19() throws ParseException {
		
		LOGGER.info("Start");
		List<Stock> stocks = stockService.getFbSept19();		
		for (Stock s : stocks) {			
			System.out.println(s.getCode()+";"+s.getDate()+";"+s.getOpen()+";"+s.getClose()+";"+s.getVolume());
		}
		LOGGER.info("End");
	}

	private static void testGetAllStocks() {
		LOGGER.info("Start");
		List<Stock> stocks = stockService.getAllStock();
		for (Stock s : stocks) {
			System.out.println(s);
		}
		LOGGER.info("End");

	}

}
