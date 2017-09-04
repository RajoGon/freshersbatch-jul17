package com.springmongo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmongo.collection.ActionCollection;
import com.springmongo.collection.ItemCollection;
import com.springmongo.dao.ActionDao;
import com.springmongo.dao.ItemDao;


public class ActionServiceImplementation implements ActionService{
@Autowired
ActionDao actionDao;



public ArrayList<ActionCollection> getAllActions(String token) {
	// TODO Auto-generated method stub
	return actionDao.getAllActions(token);
}

}
