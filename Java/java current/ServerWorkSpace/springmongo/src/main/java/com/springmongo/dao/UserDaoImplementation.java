package com.springmongo.dao;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.MongoClient;
import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.User;
import com.springmongo.entity.UserLogin;
import com.springmongo.repository.UserLoginRepository;
import com.springmongo.repository.UserRepository;

public class UserDaoImplementation implements UserDao{
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserLoginRepository userLoginRepository;
	public UserCollection createuser(User user) {
		System.out.println("in dao");
		UserCollection userCollection = new UserCollection();
		userCollection.setFirstName(user.getFirstName());
		userCollection.setLastName(user.getLastName());
		userCollection.setUserName(user.getUserName());
		userCollection.setPassword(user.getPassword());
		userCollection.setEmail(user.getEmail());
		userCollection.setPhone(user.getPhone());
		System.out.println(userCollection);
		userRepository.save(userCollection);
		return userCollection;
	}
	public UserLoginCollection loginUser(UserLogin userLogin) {
		System.out.println("in dao");
		UserCollection userCollection = userRepository.getUserByUsername(userLogin.getUserName(),userLogin.getPassword());
		System.out.println("found, "+userCollection);
		UserLoginCollection userLoginCollection = new UserLoginCollection();		

			if(userCollection!=null){
				userLoginCollection.setUserName(userCollection.getUserName());
				System.out.println(userLoginCollection);
				userLoginRepository.save(userLoginCollection);
				return userLoginCollection;
			}else{
				return null;
			}

	}
	public UserLoginCollection logoutUser(String token) {

		UserLoginCollection userSession =userLoginRepository.findOne(token);
		System.out.println("Found session, "+userSession);
		if(userSession!=null){
			userLoginRepository.delete(userSession);
			return userSession;
		}else{
			return null;
		}
	}
	public UserCollection getUser(String uname) {
		UserCollection userCollection = userRepository.getUser(uname);
		if(userCollection!=null){
			
			return userCollection;
		}else{
			return null;
		
		}
	}

}
