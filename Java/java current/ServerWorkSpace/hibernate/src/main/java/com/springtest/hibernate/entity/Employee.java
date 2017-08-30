package com.springtest.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name="EMPFEW")
@NamedQueries({
	@NamedQuery(name="sumSal", query = "Select sum(salary) from Employee ")
})
public class Employee {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="EMPNO")
	private float id;
	@Column(name="ENAME")
	private String name;
	@Column(name="SAL")
	private String salary;
	
	@Column(name="CITY")
	private String city;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Employee(float id, String name, String salary, String city, String dname) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.city = city;
		this.dname = dname;
	}
	private String dname;

	public float getId() {
		return id;
	}
	public void setId(float id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public Employee(){}

	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", city=" + city + ", dname=" + dname
				+ "]";
	}


}
