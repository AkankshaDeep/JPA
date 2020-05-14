package com.cognizant.ormLearn.Model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Department")
public class Department {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 @Column(name="dp_id")
	 private int id;
	 @Column(name="dp_name")
	 private String name;
	 //@OneToMany(mappedBy = "department", fetch = FetchType.EAGER) 
	 @OneToMany(mappedBy = "department") 
	 private Set<Employee> employeeList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(Set<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	} 
	 
	 
	
}
