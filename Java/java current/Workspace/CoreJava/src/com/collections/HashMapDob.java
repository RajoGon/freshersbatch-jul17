package com.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


class BDate {
	int day;
	int month;
	int year;
	public BDate(int day,int month,int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public String toString() {
		return this.day +"-"+this.month+"-"+this.year;
	}
	
	public int hashCode() {
		return 1;
	}
	@Override
	public boolean equals(Object o){
		BDate e = (BDate) o;
		if(this.day == e.day && this.month==e.month) {
			return true;
		}else {
			return false;
		}
	}
}

class PersonDob{
	public BDate dob;
	public String name;
	
	PersonDob(BDate birth, String name){
		this.dob = birth;
		this.name = name;
	}

}

public class HashMapDob {

	public static void main(String[] args) {
		PersonDob P[] = new PersonDob[5];
		P[0] = new PersonDob(new BDate(4,11,1995),"Abed");
		P[1] = new PersonDob(new BDate(2,12,2007),"Acroose");
		P[2] = new PersonDob(new BDate(4,11,1990),"Milaan");
		P[3] = new PersonDob(new BDate(29,4,2001),"Eddy");
		P[4] = new PersonDob(new BDate(12,8,2010),"Fernandes");
		HashMap<BDate,String> dobwise =new HashMap<BDate,String>(); 
		dobwise.put(P[0].dob, P[0].name);
		dobwise.put(P[1].dob, P[1].name);
		dobwise.put(P[2].dob, P[2].name);
		dobwise.put(P[3].dob, P[3].name);
		dobwise.put(P[4].dob, P[4].name);
		System.out.println("Iterating through all");
		Iterator<Entry<BDate, String>> itr = dobwise.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<BDate, String> entry =itr.next();
			System.out.println("Key = " + entry.getKey().toString() + ", Value = " + entry.getValue());
	    }
		
		System.out.println("\nTesting on same day and month "+ dobwise.get( new BDate(4,11,1995) ) );	
		System.out.println("Should return Abed, but gives Milaan");

	}

}
