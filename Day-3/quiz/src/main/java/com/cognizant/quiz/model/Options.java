package com.cognizant.quiz.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Options {
	@Id
	@Column(name = "op_id")
	private int op_id;
	@Column(name = "op_qt_id")
	private int op_qt_id;
	@Column(name = "op_score")
	private double op_score;
	@Column(name = "op_text")
	private String op_text;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="op_qt_id",referencedColumnName="qt_id", insertable=false, updatable=false)
	private Question question;
	
	
	@ManyToMany(mappedBy = "optionList") 
	private Set<Attempt> attemptList;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "options",cascade = CascadeType.ALL) 
	 private Set<AttemptOption> attemptOptionList;
	
	
	
	public Set<AttemptOption> getAttemptOptionList() {
		return attemptOptionList;
	}
	public void setAttemptOptionList(Set<AttemptOption> attemptOptionList) {
		this.attemptOptionList = attemptOptionList;
	}
	public Set<Attempt> getAttemptList() {
		return attemptList;
	}
	public void setAttemptList(Set<Attempt> attemptList) {
		this.attemptList = attemptList;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getOp_id() {
		return op_id;
	}
	public void setOp_id(int op_id) {
		this.op_id = op_id;
	}
	public int getOp_qt_id() {
		return op_qt_id;
	}
	public void setOp_qt_id(int op_qt_id) {
		this.op_qt_id = op_qt_id;
	}
	public double getOp_score() {
		return op_score;
	}
	public void setOp_score(double op_score) {
		this.op_score = op_score;
	}
	public String getOp_text() {
		return op_text;
	}
	public void setOp_text(String op_text) {
		this.op_text = op_text;
	}
	@Override
	public String toString() {
		return "Options [op_id=" + op_id + ", op_qt_id=" + op_qt_id + ", op_score=" + op_score + ", op_text=" + op_text
				+ "]";
	}
	
}
