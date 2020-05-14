package com.cognizant.quiz.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="question")
public class Question {
	@Id
	@GeneratedValue
	@Column(name="qt_id")
	private int qt_id;
	@Column(name="qt_text")
	private String qt_text;
	
	@ManyToMany(mappedBy = "questionList") 
	private Set<Attempt> attemptList;
	
	@OneToMany(mappedBy = "question",cascade = CascadeType.ALL) 
	 private Set<Options> optionsList;
	
	public Set<Options> getOptionsList() {
		return optionsList;
	}
	public void setOptionsList(Set<Options> optionsList) {
		this.optionsList = optionsList;
	}
	public Set<Attempt> getAttemptList() {
		return attemptList;
	}
	public void setAttemptList(Set<Attempt> attemptList) {
		this.attemptList = attemptList;
	}
	public int getQt_id() {
		return qt_id;
	}
	public void setQt_id(int qt_id) {
		this.qt_id = qt_id;
	}
	public String getQt_text() {
		return qt_text;
	}
	public void setQt_text(String qt_text) {
		this.qt_text = qt_text;
	}
	@Override
	public String toString() {
		return "Question [qt_id=" + qt_id + ", qt_text=" + qt_text + "]";
	}
	
}
