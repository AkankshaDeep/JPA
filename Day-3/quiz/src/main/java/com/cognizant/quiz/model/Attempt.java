package com.cognizant.quiz.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;







@Entity
@Table(name="attempt")
public class Attempt {
	@Id
	@GeneratedValue
	@Column(name="at_id")
	private int at_id;
	@Column(name="at_date")
	private Date at_date;
	@Column(name="at_us_id")
	private int at_us_id;
	@Column(name="at_score")
	private double at_score;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="at_us_id",referencedColumnName="us_id", insertable=false, updatable=false)
	private User user;
	
	@ManyToMany() 
	 @JoinTable(name = "attempt_question", 
	 joinColumns = @JoinColumn(name = "aq_at_id",referencedColumnName="at_id", insertable=false, updatable=false), 
	 inverseJoinColumns = @JoinColumn(name = "aq_qt_id")) 
	 private Set<Question> questionList; 
	 
	
	@ManyToMany() 
	 @JoinTable(name = "attempt_option", 
	 joinColumns = { @JoinColumn(name = "ao_aq_id",referencedColumnName="at_id")},	 
	 inverseJoinColumns = @JoinColumn(name = "ao_op_id")) 
	 private Set<Options> optionList; 
	 
	
	
	
	public Set<Options> getOptionList() {
		return optionList;
	}
	public void setOptionList(Set<Options> optionList) {
		this.optionList = optionList;
	}
	public Set<Question> getQuestionList() {
		return questionList;
	}
	public void setQuestionList(Set<Question> questionList) {
		this.questionList = questionList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getAt_id() {
		return at_id;
	}
	public void setAt_id(int at_id) {
		this.at_id = at_id;
	}
	public Date getAt_date() {
		return at_date;
	}
	public void setAt_date(Date at_date) {
		this.at_date = at_date;
	}
	public int getAt_us_id() {
		return at_us_id;
	}
	public void setAt_us_id(int at_us_id) {
		this.at_us_id = at_us_id;
	}
	public double getAt_score() {
		return at_score;
	}
	public void setAt_score(double at_score) {
		this.at_score = at_score;
	}
	@Override
	public String toString() {
		return "Attempt [at_id=" + at_id + ", at_date=" + at_date + ", at_us_id=" + at_us_id + ", at_score=" + at_score
				+ ", user=" + user + ", questionList=" + questionList + ", optionList=" + optionList + "]";
	}
	
	
	
}
