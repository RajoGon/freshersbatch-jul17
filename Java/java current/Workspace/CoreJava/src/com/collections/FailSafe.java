package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FailSafe {

	public static void main(String[] args) {
		ArrayList<Integer> fail = new ArrayList<Integer>();
		CopyOnWriteArrayList<Integer> safe = new CopyOnWriteArrayList<Integer>();
		ExecutorService executor = Executors.newFixedThreadPool(2); 
		Runnable t1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Executing Fail");
				for(int i=0;i<10;i++) {
					fail.add(i);
				}
				Iterator<Integer> itr = fail.iterator();
				while(itr.hasNext()) {
					System.out.println(itr.next());
					fail.add(100);
				}
			}
		};
		Runnable t2 = new Runnable() {
			
			@Override
			public void run() {
				boolean flag = true;
				System.out.println("Executing Safe");
				for(int i=0;i<10;i++) {
					safe.add(i);
				}
				
				Iterator<Integer> itr = safe.iterator();
				while(itr.hasNext()) {
					System.out.println(itr.next());
					if(flag ==true) {
						System.out.println("adding 100");
						safe.add(100);
						flag=false;
					}
					
				}
				System.out.println("Iterating again");
				Iterator<Integer> itr2 = safe.iterator();
				while(itr2.hasNext()) {
					System.out.println(itr2.next());					
				}
			}
		};
		//executor.execute(t1);
		executor.execute(t2);
		
	} 

}
