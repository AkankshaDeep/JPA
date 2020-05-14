package com.cognizant.ormLearn.Model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Skill")
public class Skill {
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) 
	 @Column(name="sk_id")
	 private int id;
	@Column(name="sk_name")
	 private String name;
	@ManyToMany(mappedBy = "skillList") 
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
		return "Skill [id=" + id + ", name=" + name + "]";
	} 
	
	
}
