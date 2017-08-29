package com.springtest.springmongo.entity;

public class User {
	private String uname;
	private String password;
	private String fname;
	public User(){}
	public User(String uname, String password, String fname) {
		super();
		this.uname = uname;
		this.password = password;
		this.fname = fname;
	}
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "User [uname=" + uname + ", password=" + password + ", fname=" + fname + "]";
	}
	
	
}
