package com.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashLinkedOrderedOrUnordered {

	public static void main(String[] args) {
		 HashSet<String> ts = new HashSet<String>();
	       ts.add("RED");
	       ts.add("ORANGE");
	       ts.add("BLUE");
	       ts.add("GREEN");
	       System.out.println("Hashset unordered");
	      Iterator<String> itr = ts.iterator();
	      while(itr.hasNext()) {
	    	  System.out.println(itr.next());
	      }
	      LinkedHashSet<String> ts2 = new LinkedHashSet<String>();
	       ts2.add("RED");
	       ts2.add("ORANGE");
	       ts2.add("BLUE");
	       ts2.add("GREEN");
	       System.out.println("\nLinkedHashSet ordered");
	      Iterator<String> itr2 = ts2.iterator();
	      while(itr2.hasNext()) {
	    	  System.out.println(itr2.next());
	      }
	      System.out.println("\n Hence proved Hashset is unordered and linked has set is ordered.");

	}

}
