package com.springmongo.dao;

import java.util.ArrayList;
import java.util.List;

import com.springmongo.collection.ItemCollection;
import com.springmongo.collection.UserCollection;
import com.springmongo.entity.User;

public interface ItemDao {
	public ArrayList<ItemCollection> getAllCategories();
}
