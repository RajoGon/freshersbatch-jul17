package com.springtest;

import java.util.ArrayList;
import java.util.Vector;

public class AddToVectorAndList {
	ArrayList<Integer> list = new ArrayList<Integer>();
	Vector<Integer> v = new Vector<Integer>();
	
	
	public void addInVector(int x[]){
		for(int a :x){
			v.addElement(a);
		}
		v.clear();
		
	}
	public void addInList(int x[]){
		for(int a :x){
			list.add(a);
		}
		list.clear();	
	}
}