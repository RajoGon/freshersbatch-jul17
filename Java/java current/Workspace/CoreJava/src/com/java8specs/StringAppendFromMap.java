package com.java8specs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;


public class StringAppendFromMap {
	static StringBuilder result=new StringBuilder();
	public static void main(String[] args) {
		HashMap<Integer,Integer> data = new HashMap<Integer,Integer>();
		data.put(1, 100);
		data.put(2, 200);
		data.put(3, 300);
		data.put(4, 400);
		
		Set<Entry<Integer, Integer>> a = data.entrySet();
		
		
		Consumer<Entry<Integer, Integer>> consumer1 = (Entry<Integer, Integer> x) -> {
			result.append(x.getKey().toString());
			result.append("=");
			result.append(x.getValue().toString());
			result.append(", ");
		
			};  
		Iterator<Entry<Integer, Integer>> itr = a.iterator();
		while(itr.hasNext()) {
			Entry<Integer, Integer> temp = itr.next();
			consumer1.accept(temp);
		}
		System.out.println(result);
		
		
	}

}
