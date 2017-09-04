package com.springmongo.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.springmongo.collection.ItemCollection;
import com.springmongo.repository.ItemRepository;


public class ItemDaoImplementation extends HibernateDaoSupport implements ItemDao{

	
	@Transactional
	public ArrayList<ItemCollection> getAllCategories() {
		Query getCategories = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from ItemCollection");
		List<ItemCollection> itemsTemp = getCategories.list();
		if(itemsTemp!=null){
			return (ArrayList<ItemCollection>) itemsTemp;
		}else{
			return null;
		}
		
	}
	
	

}
