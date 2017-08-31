package com.springtest.hibernate.entity.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="STUDENT")
public class MyStudent {
	@Id
	@GeneratedValue
	@Column(name="sid")
	private long sid;
	
	
	@Column(name="sname")
	private String name;
	@Column(name="sage")
	private String age;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="Student_Course",
			joinColumns = {@JoinColumn(name="sid")},
			inverseJoinColumns = {@JoinColumn(name="cid")}			
			)
	private Set<MyCourse> courseList= new HashSet<>();
	
	
	
	
	
	public Set<MyCourse> getCourseList() {
		return courseList;
	}
	public void setCourseList(Set<MyCourse> courseList) {
		this.courseList = courseList;
	}
	public MyStudent(String name, String age, Set<MyCourse> courseList) {
		super();
		this.name = name;
		this.age = age;
		this.courseList = courseList;
	}
	public MyStudent(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public MyStudent(long sid, String name, String age) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
	}
	public MyStudent() {
		super();
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "MyStudent [sid=" + sid + ", name=" + name + ", age=" + age + "]";
	}
	
	
}
