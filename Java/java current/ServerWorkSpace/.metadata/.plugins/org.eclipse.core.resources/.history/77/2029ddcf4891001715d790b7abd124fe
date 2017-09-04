package com.springmongo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.dao.UserDao;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;

public class UserServiceImplementation implements UserService{
	@Autowired
	UserDao userDao;
	public User createUser(User user){
		System.out.println("In service");
		return userDao.createuser(user);
	}
	public User loginUser(UserLogin userLogin) {
		System.out.println("In service");
		return userDao.loginUser(userLogin);
	}
	public UserLoginCollection logoutUser(String token) {		
		return userDao.logoutUser(token);
	}
	public UserCollection getUser(String uname) {
		return userDao.getUser(uname);
	}	
	

}
