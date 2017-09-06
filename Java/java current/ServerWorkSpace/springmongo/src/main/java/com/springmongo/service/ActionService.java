package com.springmongo.service;

import java.util.ArrayList;
import java.util.List;

import com.springmongo.collection.ActionCollection;
import com.springmongo.collection.ItemCollection;
import com.springmongo.entity.DateConditions;


public interface ActionService {
	public ArrayList<ActionCollection> getAllActions(String token);

	public ArrayList<DateConditions> getAllDateConditions(String token);
}
