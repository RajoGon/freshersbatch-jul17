package com.springmongo.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.springmongo.collection.ActionCollection;
import com.springmongo.collection.ItemCollection;
import com.springmongo.entity.DateConditions;
import com.springmongo.repository.ActionRepository;
import com.springmongo.repository.ItemRepository;


public class ActionDaoImplementation extends HibernateDaoSupport implements ActionDao{
	@Transactional
	public ArrayList<ActionCollection> getAllActions(String token) {
		boolean verify = verifyToken(token);
		if(verify==true){
			Query actions = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from ActionCollection");
			ArrayList<ActionCollection> actionList = (ArrayList<ActionCollection>) actions.list();
			if(actionList!=null){
				return actionList;
			}else{
				return null;
			}
		}else{
			return null;
		}
		
		
	}
	
	@Transactional
	public ArrayList<DateConditions> getAllDateConditions(String token) {
		boolean verify = verifyToken(token);
		if(verify==true){
			Query dates = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from DateConditions");
			ArrayList<DateConditions> datesList = (ArrayList<DateConditions>) dates.list();
			if(datesList!=null){
				return datesList;
			}else{
				return null;
			}
		}else{
			return null;
		}
	}

	public boolean verifyToken(String token){
		org.hibernate.Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from UserLoginCollection where id=:authToken ");
		q.setParameter("authToken", token);
		
		if(q.list()!=null){
			return true;
		}else{
			return false;
		}
	}

	
	
	

}
