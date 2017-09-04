package com.springmongo.service;

import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;

public interface UserService {
	public User createUser(User user);
	public UserLoginCollection loginUser(UserLogin userLogin);
	public String logoutUser(String token);
	public User getUser(String uname);
}
