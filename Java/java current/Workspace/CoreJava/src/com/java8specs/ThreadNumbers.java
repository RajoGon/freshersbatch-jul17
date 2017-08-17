package com.java8specs;

import java.util.ArrayList;

import java.util.function.Consumer;

class NumberList extends Thread{
	ArrayList<Integer> data = new ArrayList<Integer>();
	NumberList(){
		data.add(1);
		data.add(2);
		data.add(3);
		data.add(4);
		data.add(5);
		this.start();
	}
	@Override
	public void run() {
		System.out.println("Printing list of integers using consumer");
		Consumer<Integer> consumer1 =(Integer x) -> System.out.println(x);
		for(Integer a : data) {
			consumer1.accept(a);
		}
	}
}
public class ThreadNumbers {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		NumberList t = new NumberList();

	}

}
