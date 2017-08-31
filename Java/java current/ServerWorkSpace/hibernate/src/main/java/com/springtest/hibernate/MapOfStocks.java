package com.springtest.hibernate;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.springtest.hibernate.entity.mapstock.*;



public class MapOfStocks {
	static Long mid;
	static Long midToDelete;
	public static void main(String[] args) {
		//1.	2.	Perform CRUD operations on tables having 1-m mapping i.e. Market & Stock. The entity attributes will be Market (id, name, city) & Stock(id, name, price, market_id). Try all cascade options.
		Configuration config=new Configuration();
    	config.configure("hibernate.cfg.xml");
    	SessionFactory sessionFactory = config.buildSessionFactory();
    	//Create
    	create(sessionFactory);
    	//Retreive
    	//retreive(sessionFactory);
    	//Update
    	//update(sessionFactory);
    	//Delete
    	//delete(sessionFactory);
    	
    	
    	
    	sessionFactory.close();
	}
    public static void create(SessionFactory sessionFactory){
    	//Different queries
    	Session session = sessionFactory.openSession();
    	Transaction tobj = session.beginTransaction();
    	Market m1 = new Market("Nagpur", "Wallstreet");
    	Market m2 = new Market("Pune", "Dalalstreet");
    	Stock s1 = new Stock(1000,m1);
    	Stock s2 = new Stock(2000,m1);
    	Stock s3 = new Stock(3000,m1);
    	Stock s4 = new Stock(4000,m2);
    	Stock s5 = new Stock(5000,m2);
    	session.persist(s1);
    	session.persist(s2);
    	session.persist(s3);
    	session.persist(s4);
    	session.persist(s5);
    	Map<Long,Stock> stockm1 = new HashMap<Long,Stock>();
    	stockm1.put(s1.getId(), s1);
    	stockm1.put(s2.getId(), s2);
    	stockm1.put(s3.getId(), s3);
    	Map<Long,Stock> stockm2 = new HashMap<Long,Stock>();
    	stockm2.put(s4.getId(), s4);
    	stockm2.put(s5.getId(), s5);

    	m1.setStocks(stockm1);
    	m2.setStocks(stockm2);
    	
    	session.persist(m1);
    	session.persist(m2);
    	tobj.commit();
    	mid = m1.getId();
    	midToDelete = m2.getId();
    	session.close();	
    	System.out.println("Marktet with stocks inserted Successfully");
    }
//    public static void retreive(SessionFactory sessionFactory){
//    	//Different queries
//    	
//    	Session session = sessionFactory.openSession();
//    	Transaction tobj = session.beginTransaction();
//    	Market m_find = session.load(Market.class, mid);
//    	System.out.println(m_find);
//    	tobj.commit();
//    	session.close();	
//    	System.out.println("Market found Successfully");
//    }
//    public static void update(SessionFactory sessionFactory){
//    	//Different queries
//    	
//    	Session session = sessionFactory.openSession();
//    	Transaction tobj = session.beginTransaction();
//    	Market m_find = session.load(Market.class, mid);
//    	m_find.setCity("NagpurCity");
//    	m_find.getStocks().stream().collect(Collectors.toList()).get(1).setPrice(750);
//    	tobj.commit();
//    	session.close();	
//    	System.out.println("Market updated Successfully");
//    }
//    
//    public static void delete(SessionFactory sessionFactory){
//    	//Different queries
//    	
//    	Session session = sessionFactory.openSession();
//    	Transaction tobj = session.beginTransaction();
//    	Market m_find = session.load(Market.class, midToDelete);
//    	Stock s_find = m_find.getStocks().stream().collect(Collectors.toList()).get(1);
//    	//System.out.println(s_find);
//    	m_find.getStocks().remove(s_find);
//    	session.delete(s_find);
//    	tobj.commit();
//    	session.close();	
//    	System.out.println("Stock deleted Successfully");
//    }
}
