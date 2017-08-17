package com.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListNumbers {

	static void printList(List<? extends Number> list) {
		Iterator<?> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++) {
			list.add(i);
		}
		
		printList(list);
	}

}
