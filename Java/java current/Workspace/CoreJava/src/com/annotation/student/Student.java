package com.annotation.student;
import com.annotation.getter.*;
public class Student {
	public int marks;
	public String name;
	
	public Student(){
		this.marks = 90;
		this.name = "Rajo";
	}
	@Getter
	public int getMarks(){
		//System.out.println("Hello");
		return this.marks;
	}
	@Getter
	public String getName(){
		//System.out.println("Hello");
		return this.name;
	}
}