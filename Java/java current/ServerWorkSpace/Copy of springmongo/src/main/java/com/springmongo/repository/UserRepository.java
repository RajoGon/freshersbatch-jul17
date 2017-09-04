package com.springmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;
import com.springmongo.entity.UserLogin;


public interface UserRepository extends MongoRepository<UserCollection, String>{
	@Query(value="{userName:?0 , password:?1}")
	public UserCollection getUserByUsername(String userName,String password);
	
	@Query(value="{userName:?0}")
	public UserCollection getUser(String uname);
}
