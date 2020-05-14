package com.cognizant.quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="attempt_option")
public class AttemptOption {

	@Id
	@Column(name="ao_id")
	private int ao_id;
	
	@Column(name="ao_aq_id")
	private int ao_aq_id;
	
	@Column(name="ao_op_id")
	private int ao_op_id;
	
	@Column(name="ao_selected",nullable = false, columnDefinition = "TINYINT(1)")
	private boolean ao_selected;

	@ManyToOne(optional=false)
	@JoinColumn(name="ao_op_id",referencedColumnName="op_id", insertable=false, updatable=false)
	private Options options;
	
	
	
	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}

	public int getAo_id() {
		return ao_id;
	}

	public void setAo_id(int ao_id) {
		this.ao_id = ao_id;
	}

	public int getAo_aq_id() {
		return ao_aq_id;
	}

	public void setAo_aq_id(int ao_aq_id) {
		this.ao_aq_id = ao_aq_id;
	}

	public int getAo_op_id() {
		return ao_op_id;
	}

	public void setAo_op_id(int ao_op_id) {
		this.ao_op_id = ao_op_id;
	}

	public boolean isAo_selected() {
		return ao_selected;
	}

	public void setAo_selected(boolean ao_selected) {
		this.ao_selected = ao_selected;
	}

	@Override
	public String toString() {
		return ""+ao_selected;
	}
	
	
	
}
