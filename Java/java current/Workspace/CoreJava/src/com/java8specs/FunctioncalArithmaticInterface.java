package com.java8specs;

@FunctionalInterface
interface Arithmatic<T extends Number>{
	T test(T a, T b);
}

public class FunctioncalArithmaticInterface {

	public static void main(String[] args) {
		int a = 50;
		int b = 10;
		Arithmatic<Integer> add = (Integer x,Integer y) -> x+y;
		System.out.println(add.test(a, b));
		Arithmatic<Integer> sub = (Integer x,Integer y) -> x-y;
		System.out.println(sub.test(a, b));
		Arithmatic<Integer> mul = (Integer x,Integer y) -> x*y;
		System.out.println(mul.test(a, b));
		Arithmatic<Integer> div = (Integer x,Integer y) -> x/y;
		System.out.println(div.test(a, b));
	}

}
