package com.springmongo.dao;

import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;

public interface UserDao {
	public User createuser(User user);
	public User loginUser(UserLogin userLogin);
	public UserLoginCollection logoutUser(String token);
	public UserCollection getUser(String uname);
}
