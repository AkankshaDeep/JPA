package com.cognizant.quiz.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="user")
public class User {
	@Id
	@Column(name="us_id")
	private int us_id;
	@Column(name="us_name")
	private String us_name;
	@Column(name="us_email")
	private String us_email;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL) 
	 private Set<Attempt> attemptList;
	
	public Set<Attempt> getAttemptList() {
		return attemptList;
	}
	public void setAttemptList(Set<Attempt> attemptList) {
		this.attemptList = attemptList;
	}
	public int getUs_id() {
		return us_id;
	}
	public void setUs_id(int us_id) {
		this.us_id = us_id;
	}
	public String getUs_name() {
		return us_name;
	}
	public void setUs_name(String us_name) {
		this.us_name = us_name;
	}
	public String getUs_email() {
		return us_email;
	}
	public void setUs_email(String us_email) {
		this.us_email = us_email;
	}
	@Override
	public String toString() {
		return "User [us_id=" + us_id + ", us_name=" + us_name + ", us_email=" + us_email + "]";
	}
	
	
}
