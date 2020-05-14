package com.cognizant.quiz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="attempt_question")
public class AttemptQuestion {

	@Id
	@GeneratedValue
	@Column(name="aq_id")
	private int aq_id;
	
	@Column(name="aq_at_id")
	private int aq_at_id;
	
	@Column(name="aq_qt_id")
	private int aq_qt_id;
	
	
	
	public int getAq_at_id() {
		return aq_at_id;
	}

	public void setAq_at_id(int aq_at_id) {
		this.aq_at_id = aq_at_id;
	}

	public int getAq_qt_id() {
		return aq_qt_id;
	}

	public void setAq_qt_id(int aq_qt_id) {
		this.aq_qt_id = aq_qt_id;
	}

	/*@ManyToMany() 
	 @JoinTable(name = "attempt_option", 
	 joinColumns = { @JoinColumn(name = "ao_aq_id",referencedColumnName="aq_qt_id")},	 
	 inverseJoinColumns = @JoinColumn(name = "ao_op_id")) 
	 private Set<Options> optionList; 
	 
	
	
	public Set<Options> getOptionList() {
		return optionList;
	}

	public void setOptionList(Set<Options> optionList) {
		this.optionList = optionList;
	}
*/
	public int getAq_id() {
		return aq_id;
	}

	public void setAq_id(int aq_id) {
		this.aq_id = aq_id;
	}
	
	
	
}
