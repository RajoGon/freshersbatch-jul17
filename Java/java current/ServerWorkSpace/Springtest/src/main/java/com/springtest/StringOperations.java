package com.springtest;

public class StringOperations {
	
	public String getCapStr(String str)  throws Exception{
		str = str.toUpperCase();
		return str;
	}
	public String getLowerStr(String str) throws Exception{
		str=null;
		str = str.toLowerCase();
		return str;
	}
	public int getLength(String str) throws Exception{	
		return str.length();
	}
}