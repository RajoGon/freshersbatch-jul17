package com.springtest.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.springtest.hibernate.entity.Product;

/**
 * Hello world!
 *
 */
public class App2 
{
    public static void main( String[] args )
    {
    	//Configure hibernate by reading config file
    	Configuration config=new Configuration();
    	config.configure("hibernate.cfg.xml");
    	//Create a session factory object through configured object
    	SessionFactory sessionFactory = config.buildSessionFactory();

    	//getAll(sessionFactory);

    }
    
  
    
    public static void getTotalSal(SessionFactory sessionFactory){
    	//Different queries
    	Session session = sessionFactory.openSession();
    	Transaction tobj = session.beginTransaction();
    	Query query = session.createQuery("Select sum(salary) from Employee  ");
    	long sum = query.executeUpdate();
    	System.out.println("Total sal = "+sum);
    	//Commit and close
    	tobj.commit();
    	session.close();
    	System.out.println("Data found Successfully");
    }

 }