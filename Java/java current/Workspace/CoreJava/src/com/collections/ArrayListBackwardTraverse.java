package com.collections;

import java.util.ArrayList;

import java.util.ListIterator;

public class ArrayListBackwardTraverse {

	public static void main(String[] args) {
		ArrayList <String> ts = new ArrayList <String>();
	       ts.add("RED");
	       ts.add("ORANGE");
	       ts.add("BLUE");
	       ts.add("GREEN");
	       ts.add("PURPLE");
	       ts.add("BLACK");
	       System.out.println("List iterator");
	      ListIterator<String> itr = ts.listIterator(ts.size());
	      while(itr.hasPrevious()) {
	    	  System.out.println(itr.previous());
	      }

	}

}
