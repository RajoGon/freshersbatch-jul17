package com.springmongo.service;

import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;

public interface UserService {
	public User createUser(User user);
	public User loginUser(UserLogin userLogin);
	public UserLoginCollection logoutUser(String token);
	public UserCollection getUser(String uname);
}
