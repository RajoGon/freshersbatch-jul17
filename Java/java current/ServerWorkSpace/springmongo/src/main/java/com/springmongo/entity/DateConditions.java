package com.springmongo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DATECONDITIONS")
public class DateConditions {
	@Id
	@Column(name="id")
	int id;
	@Column(name="name")
	String datecondition;
	public DateConditions(){}
	public DateConditions(int id, String datecondition) {
		super();
		this.id = id;
		this.datecondition = datecondition;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDatecondition() {
		return datecondition;
	}
	public void setDatecondition(String datecondition) {
		this.datecondition = datecondition;
	}
	public DateConditions(String datecondition) {
		super();
		this.datecondition = datecondition;
	}
	
}