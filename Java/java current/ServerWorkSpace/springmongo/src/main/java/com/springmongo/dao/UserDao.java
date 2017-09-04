package com.springmongo.dao;

import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;

public interface UserDao {
	public User createuser(User user);
	public UserLoginCollection loginUser(UserLogin userLogin);
	public String logoutUser(String token);
	public User getUser(String uname);
}
