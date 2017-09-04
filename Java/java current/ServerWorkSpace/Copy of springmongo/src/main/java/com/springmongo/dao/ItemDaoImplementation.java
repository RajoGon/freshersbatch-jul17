package com.springmongo.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import com.springmongo.collection.ItemCollection;
import com.springmongo.repository.ItemRepository;


public class ItemDaoImplementation implements ItemDao{
	@Autowired
	ItemRepository itemRepository;
	public ArrayList<ItemCollection> getAllCategories() {
		
		ArrayList<ItemCollection> itemsTemp = (ArrayList<ItemCollection>) itemRepository.findAll();
		if(itemsTemp!=null){
			return itemsTemp;
		}else{
			return null;
		}
		
	}
	
	

}
