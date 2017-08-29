package com.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springmongo.collection.ActionCollection;
public interface ActionRepository extends MongoRepository<ActionCollection, String>{
}
