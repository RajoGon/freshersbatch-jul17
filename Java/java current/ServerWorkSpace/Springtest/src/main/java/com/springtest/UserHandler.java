package com.springtest;

import java.util.ArrayList;

public class UserHandler {
	User u;
	boolean loginStatus = false;
	static ArrayList<User> users = new ArrayList<>();
	long loginTime;
	long logoutTime;
	public void login(String user){
		boolean found = false;
		for(User a:users){
			String name = a.getLoginName();
			if(name.equals(user)){
			found = true;
			a.setLoginTime(System.currentTimeMillis());
			}
		}
		if(found==false){
			System.out.println("No such user.");
		}

	}
	public void logout(String user){
		boolean found = false;
		for(User a:users){
			String name = a.getLoginName();
			if(name.equals(user)){
				found=true;
				if(a.getLoginTime()!=0){
					a.setLogoutTime(System.currentTimeMillis()); 
					System.out.println("Session duration for user, "+a.getLoginName()+" is "+(a.getLogoutTime()-a.getLoginTime())+" milliseconds");
					a.setLoginTime(0);
				}else{
					System.out.println("Please login user first");
				}
			}
		}
		if(found==false){
			System.out.println("Register user first.");
		}
	
	}
	
	public void register(String loginName, String password, String firstName, String country){
		u = new User(loginName, password, firstName, country);
		users.add(u);
	}
	
	

	
}
