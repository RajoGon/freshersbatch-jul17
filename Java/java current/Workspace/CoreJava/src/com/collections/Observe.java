package com.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class Employee{
	int id;
	Employee(int id){
		this.id = id;
	}
	@Override
	public int hashCode() {
		return 0;
	}
	@Override
	public boolean equals(Object e) {
		return true;	
	}
	@Override
	public String toString() {
		return this.id+"";
	}

}
public class Observe {

	public static void main(String[] args) {
	HashMap<Employee,Integer> emp =new HashMap<Employee,Integer>(); 

	emp.put(new Employee(113),3);
	emp.put(new Employee(112),2);
	emp.put(new Employee(111),1);
	emp.put(new Employee(115),5);
	emp.put(new Employee(114),4);
	System.out.println("Iterating through all");
	Iterator<Entry<Employee, Integer>> itr = emp.entrySet().iterator();
	while (itr.hasNext()) {
		Entry<Employee, Integer> entry =itr.next();
		System.out.println("Key = " + entry.getKey().toString() + ", Value = " + entry.getValue());
    }

	}

}
