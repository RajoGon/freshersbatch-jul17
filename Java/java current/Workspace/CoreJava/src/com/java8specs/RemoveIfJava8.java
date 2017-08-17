package com.java8specs;

import java.util.ArrayList;
import java.util.function.Predicate;

public class RemoveIfJava8 {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=0 ; i<10; i++) {
			nums.add(i);
		}
		for(Integer a: nums) {
			System.out.println(a);
		}
		System.out.println("After remove");
		Predicate<Integer> removeOdd = (Integer x) -> x%2!=0;

		nums.removeIf(removeOdd);
				
		for(Integer a: nums) {
			System.out.println(a);
		}	
	}
}

