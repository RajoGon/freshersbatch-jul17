package com.springtest.hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



import com.springtest.hibernate.entity.singletable.*;
public class HibernateInheritanceSingleTable {
	static Long empid;
	static Long empidToDelete;
	public static void main(String[] args) {
//1.	Suppose there is hierarchy of entities Vehicle, Car, Bike where Vehicle is a base class for Car & Bike. Write hibernate application to map these entities into database using 3 strategies:
//		a.	Table Per Hierarchy
//		b.	Table Per Concrete class
//		c.	Table Per Subclass

		Configuration config=new Configuration();
    	config.configure("hibernate.cfg.xml");
    	SessionFactory sessionFactory = config.buildSessionFactory();
    	//Create
    	singleTable(sessionFactory);  	
    	sessionFactory.close();
	}
    public static void singleTable(SessionFactory sessionFactory){
    	//Different queries
    	Vehicle v1 = new Vehicle("Red");
    	Car c1 = new Car("Honda");
    	Bike b1 = new Bike("100HP");
    	Session session = sessionFactory.openSession();
    	Transaction tobj = session.beginTransaction();
    	session.persist(v1);
    	session.persist(c1);
    	session.persist(b1);
    	tobj.commit();
    	session.close();	
    	System.out.println("Vehicle,car and bike inserted Successfully");
    }

}