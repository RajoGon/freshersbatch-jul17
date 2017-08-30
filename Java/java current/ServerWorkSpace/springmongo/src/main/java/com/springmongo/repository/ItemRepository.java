package com.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springmongo.collection.ItemCollection;
import com.springmongo.collection.UserCollection;

public interface ItemRepository extends MongoRepository<ItemCollection, String>{
}