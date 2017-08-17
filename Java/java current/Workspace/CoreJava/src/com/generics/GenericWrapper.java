package com.generics;
class MyWrapper<T>{
	T data;
	MyWrapper(T obj){
		this.data = obj;
	}
	public T getObj() {
		return this.data;
	}
}
public class GenericWrapper {

	public static void main(String[] args) {
		
		MyWrapper<?> a = new MyWrapper<String>(new String("10"));
		System.out.println(a.getObj());
	}

}
