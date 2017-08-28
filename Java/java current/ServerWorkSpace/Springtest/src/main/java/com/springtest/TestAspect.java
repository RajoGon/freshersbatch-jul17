package com.springtest;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {

	public static void main(String[] args) throws InterruptedException{
		//1.	Write a class StringOperations with few string related methods like getCapStr(), getLowerStr(), getLength() etc. Now call these methods using any main class. Inject an aspect that gives us report of exceptions thrown while string operation methods were invoked. The report should have information about method name & exception type.
		AbstractApplicationContext iocContainer = new ClassPathXmlApplicationContext("beans_aop.xml");	
		Object stropp = iocContainer.getBean("stringBean");
		StringOperations strop = (StringOperations) stropp;
		try {
			System.out.println("To upper in main "+strop.getCapStr("Hello"));
		} catch (Exception e1) {}
		try {
			System.out.println("To lower in main "+strop.getLowerStr("Hello"));
		} catch (Exception e) {}
		try {
			System.out.println("Length in main "+strop.getLength("Hello"));
		} catch (Exception e) {}
		
		//2.	Write a class having 2 methods addInVector() & addInList(). These methods add 1000 integers into vector & arraylist respectively. Write an aspect to measure the time required to perform both operations individually.
		System.out.println("\n");
		//		AddToVectorAndList addIt = (AddToVectorAndList) iocContainer.getBean("addtovectorandlistBean");
//		int[] x=new int[1000];
//		for(int i =0 ; i<1000 ; i++){
//			x[i] = i;
//		}
//		addIt.addInVector(x);
//		addIt.addInList(x);
//		addIt.addInVector(x);
//		addIt.addInList(x);
		
		
		//3.	Write a POJO called User having attributes loginname, password, firstname & country. Add a class UserHandler having methods login(), logout() & register() that maintains the data in collection. Here are specific requirements for every method:
//		A.	In order to login, the username must be minimum 3 characters.
//		B.	Logout() method throws exception if we try logout an user which has not logged in. We want to show this error in proper string format instead of exception stack trace.
//		C.	Register(): Username & password both must be minimum3 characters long.
//		D.	Introduce the Audit trailing which will give us report about how long every client’s session remained active.
		System.out.println("\n");
		UserHandler x = (UserHandler) iocContainer.getBean("userBean");
		x.register("ABCD", "1234", "Abcdffd", "India");
		x.login("ABCD");
		x.register("DEF", "1234", "Abcdffd", "India");
		x.login("DEF");
		x.register("MNOPQ", "1234", "Abcdffd", "India");
		x.login("MNOPQ");
		x.register("JKFLG", "1234", "Abcdffd", "India");
		Thread.sleep(1000);
		x.logout("WXYZ");
		x.logout("JKFLG");
		x.logout("ABCD");
		Thread.sleep(500);
		x.logout("MNOPQ");
		
		
		iocContainer.close();
	}

}
