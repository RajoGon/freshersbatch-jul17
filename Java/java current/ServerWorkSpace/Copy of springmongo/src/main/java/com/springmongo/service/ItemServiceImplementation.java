package com.springmongo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmongo.collection.ItemCollection;

import com.springmongo.dao.ItemDao;


public class ItemServiceImplementation implements ItemService{
@Autowired
ItemDao itemDao;

public ArrayList<ItemCollection> getAllCategories() {	
	return itemDao.getAllCategories();
}

}
