package com.springtest.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.springtest.hibernate.entity.onetoone.Employee;
import com.springtest.hibernate.entity.onetoone.Profile;
public class OneToOne {
	static Long empid;
	static Long empidToDelete;
	public static void main(String[] args) {
		//1.	Perform CRUD operations on tables having 1-1 mapping i.e. Employee & Profile.
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
    	Profile p1 = new Profile("Xoriant", 1);
    	Profile p2 = new Profile("Google", 2);
    	Profile p3 = new Profile("Oracle", 3);
    	Employee e1 = new Employee("Rajo", 34000, p1);
    	Employee e2 = new Employee("Aditya", 34000, p2);
    	Employee e3 = new Employee("Sachin", 34000, p3);
    	Session session = sessionFactory.openSession();
    	Transaction tobj = session.beginTransaction();
    	session.persist(e1);	
    	session.persist(e2);	
    	session.persist(e3);	
    	tobj.commit();
    	empid = e1.getEmployeeId();
    	empidToDelete = e3.getEmployeeId();
    	session.close();	
    	System.out.println("Employee inserted Successfully");
    }
    public static void retreive(SessionFactory sessionFactory){
    	//Different queries
    	
    	Session session = sessionFactory.openSession();
    	Transaction tobj = session.beginTransaction();
    	Employee e_find = session.load(Employee.class, empid);
    	System.out.println(e_find);
    	tobj.commit();
    	session.close();	
    	System.out.println("Employee found Successfully");
    }
    public static void update(SessionFactory sessionFactory){
    	//Different queries
    	
    	Session session = sessionFactory.openSession();
    	Transaction tobj = session.beginTransaction();
    	Employee e_find = session.load(Employee.class, empid);
    	e_find.setName("Rajorshi");
    	tobj.commit();
    	session.close();	
    	System.out.println("Employee updated Successfully");
    }
    
    public static void delete(SessionFactory sessionFactory){
    	//Different queries
    	
    	Session session = sessionFactory.openSession();
    	Transaction tobj = session.beginTransaction();
    	Employee e_find = session.load(Employee.class, empidToDelete);
    	session.delete(e_find);
    	tobj.commit();
    	session.close();	
    	System.out.println("Employee deleted Successfully");
    }
}