package com.generics;

import java.util.HashMap;
import java.util.Iterator;

public class GenericMapKey<T> {
	
	static void printMapKeyValues(HashMap<? extends Number,?> hmap) {
		Iterator<? extends Number> itr = hmap.keySet().iterator();
		while(itr.hasNext()) {
			Number a = itr.next();
			System.out.println(a+""+hmap.get(a));
		}
	}
	public static void main(String[] args) {
		HashMap<Integer,String> genericMap = new HashMap<Integer,String>();
		for(int i=0 ; i<5 ; i++) {
			genericMap.put(i, "Some data");
		}
		
		printMapKeyValues(genericMap);
	}

}
