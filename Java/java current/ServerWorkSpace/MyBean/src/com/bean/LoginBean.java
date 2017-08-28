package com.bean;

public class LoginBean {
private String uname;
private String password;
	public LoginBean(String uname, String password) {
	
		this.uname = uname;
		this.password = password;
	}
	public boolean login(){
		if(this.uname.equals(this.password)){
			return true;
		}else{
			return false;
		}
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
	

}
