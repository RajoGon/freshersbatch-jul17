package com.springtest.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.springtest.hibernate.entity.Product;

public class HibernateCaching {
	public static void main(String[] args) throws InterruptedException {
		Configuration config=new Configuration();
    	config.configure("hibernate.cfg.xml");
    	SessionFactory sessionFactory = config.buildSessionFactory();
    	
    	create(sessionFactory);
    	//Retreive
    	//retreive(sessionFactory);
    	//Update
    	//update(sessionFactory);
    	//Delete
    	//delete(sessionFactory);
    	
    	
    	
    	sessionFactory.close();
    	Configuration config2=new Configuration();
    	config2.configure("hibernate.cfg.xml");
    	SessionFactory sessionFactory2 = config2.buildSessionFactory();
    	System.out.println("Second factory");
    	sessionFactory2.close();
	}
	
	public static void create(SessionFactory sessionFactory) throws InterruptedException{
    	//Different queries
		Product p = new Product("TV", 1000);
    	Session session = sessionFactory.openSession();
    	Transaction tobj = session.beginTransaction();
    	session.persist(p);
    	tobj.commit();
    	Product test = session.load(Product.class, p.getId());
    	System.out.println(test);
    	session.close();	
    	System.out.println("Session 1 Done");
    	
    	//sessionFactory.getCache().evictAllRegions();
    	//Thread.sleep(6000);
    	
    	Session session2 = sessionFactory.openSession();
    	Transaction tobj2 = session2.beginTransaction();
    	Product test2 = session2.load(Product.class, p.getId());
    	test2.setName("AC");
    	System.out.println(test2);
    	create2(sessionFactory,test2.getId());
    	tobj2.commit();
    	session2.close();	
    	System.out.println("Session 2 Done");
    	
    }
	public static void create2(SessionFactory sessionFactory, Long id) throws InterruptedException{
    	//Different queries
    	Session session3 = sessionFactory.openSession();
    	Transaction tobj3 = session3.beginTransaction();
    	
    	Product test = session3.load(Product.class, id);
    	System.out.println(test.getName());
    	
    	tobj3.commit();
    	System.out.println(test);
    	session3.close();	
    	System.out.println("Session 1 Done");

    	
    }
	
}
