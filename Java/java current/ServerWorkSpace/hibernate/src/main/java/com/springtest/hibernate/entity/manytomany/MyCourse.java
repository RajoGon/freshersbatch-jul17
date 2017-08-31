package com.springtest.hibernate.entity.manytomany;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="COURSE")
public class MyCourse {
	@Id
	@GeneratedValue
	@Column(name="cid")
	private long cid;
	
	
	@Column(name="cname")
	private String courseName;
	@Column(name="cduration")
	private String courseDuration;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="Student_Course",
			joinColumns = {@JoinColumn(name="cid")},
			inverseJoinColumns = {@JoinColumn(name="sid")}			
			)
	private Set<MyStudent> studentList = new HashSet<>();
	
	
	public MyCourse(String courseName, String courseDuration, Set<MyStudent> studentList) {
		super();
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.studentList = studentList;
	}
	public MyCourse(String courseName, String courseDuration) {
		super();
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}
	public MyCourse(long cid, String courseName, String courseDuration) {
		super();
		this.cid = cid;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
	}
	public MyCourse() {
		super();
	}
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDuration() {
		return courseDuration;
	}
	public Set<MyStudent> getStudentList() {
		return studentList;
	}
	public void setStudentList(Set<MyStudent> studentList) {
		this.studentList = studentList;
	}
	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}
	@Override
	public String toString() {
		return "MyCourse [cid=" + cid + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", studentList=" + studentList + "]";
	}
	
	
}
