package com.springtest;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		//1.	Write a program to find out total price of all orders. Every order is associated with one item which is holding item name & item price. Note that your main program is not aware of how many orders you have configured into beans.xml & what are their ids.
		AbstractApplicationContext iocContainer = new ClassPathXmlApplicationContext("Beans_simple.xml");		
		System.out.println("Total Price of items = "+iocContainer.getBeansOfType(Order.class).entrySet().stream().map(Map.Entry::getValue).map(Order::getItem).map(Item::getPrice).mapToInt(Integer::intValue).sum());
		iocContainer.close();
		// OR
		System.out.println("Total Price of items = "+new ClassPathXmlApplicationContext("Beans_simple.xml").getBeansOfType(Order.class).entrySet().stream().map(Map.Entry::getValue).map(Order::getItem).map(Item::getPrice).mapToInt(Integer::intValue).sum());
		
		
		//3.	Write a beans xml to hold data of chat application static data. Chat application has different chat rooms, every chat room has several users & users send messages which are shown within that chat room only. Write a Java class that prints every chatroom along with its users along with list of messages in pretty format.
		
		
//		AbstractApplicationContext iocContainer2 = new ClassPathXmlApplicationContext("Chat.xml");
//		List<ChatRoom> crooms = iocContainer2.getBeansOfType(ChatRoom.class).entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
//		for(ChatRoom a: crooms){
//			System.out.println("Chatroom name: "+a.getName());
//			System.out.println("  User are: "+a.getUsers());
//			System.out.println("  Messages are: "+a.getMessages());
//		}		
//		iocContainer2.close();
		
		
		//4.	Write 2 beans EmployeeBean & DepartmentBean. Autowire them using following methods:
//		a.	autowire byName
//		b.	autowire byType
//		c.	autowire by constructor
//		d.	@Autowired annotation
//		e.	@Qualifier annotation
//		AbstractApplicationContext iocContainer3 = new ClassPathXmlApplicationContext("Employee_department.xml");
//		List<Employee> crooms = iocContainer3.getBeansOfType(Employee.class).entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
//		for(Employee a: crooms){
//			System.out.println("Employee name: "+a.getName());
//			System.out.println("Employee Department: "+a.getDname());
//
//		}
	}
}
