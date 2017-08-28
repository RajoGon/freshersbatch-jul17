package com.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	private String name;
	//@Autowired
	//@Qualifier("dept1")
	private Department dname;
	
	public Employee(Department dname) {
		super();
		this.dname = dname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDname() {
		return dname;
	}
	public void setDname(Department dname) {
		this.dname = dname;
	}
	
}
