package com.java8specs;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class StringConsumer {
	static StringBuilder result=new StringBuilder();
	static StringBuilder upperCase=new StringBuilder();
	
	public static void main(String[] args) {
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("AXxxxx");
		data.add("BXxxxx");
		data.add("CXxxxx");
		data.add("DXxxxx");
		
		Consumer<String> consumer1 = (String x) -> {
			result.append(x.charAt(0));
			};  
		for(String a : data) {
			consumer1.accept(a);
		}
		System.out.println("Resultant string is, "+result);
		UnaryOperator<String> toup = (String x )-> x.toUpperCase();
		
		Consumer<ArrayList<String>> consumer2 = (ArrayList<String> Strs) ->  { 				
				for(String a : Strs) {				
					a = a.replaceAll(a, toup.apply(a));
					System.out.println(a);
				}	
			};
			consumer2.accept(data);
		
			
			
	}

}
