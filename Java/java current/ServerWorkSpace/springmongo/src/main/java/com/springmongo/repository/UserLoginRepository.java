package com.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springmongo.collection.UserCollection;
import com.springmongo.collection.UserLoginCollection;

public interface UserLoginRepository  extends MongoRepository<UserLoginCollection, String>{

}
