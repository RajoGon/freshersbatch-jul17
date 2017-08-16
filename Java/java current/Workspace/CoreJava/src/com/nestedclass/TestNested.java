package com.nestedclass;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
@SuppressWarnings("unused")
class MyBox{
	private HashMap<Integer,ArrayList<? extends Object>> data=new HashMap<Integer,ArrayList<? extends Object>>();  

	Timestamp timestamp;
	public MyBox(int id, String name) {
		this.timestamp = new Timestamp(System.currentTimeMillis());
		
		ArrayList<? extends Object> store = new ArrayList<>(
			    Arrays.asList(name,this.timestamp));
		data.put(id,store);

	}
	
	private class MyCache{	
		public void getDetails(int key){
			if(data.get(key)==null)
			{
				System.out.println("Illegal Access");
			}else{
				System.out.println(data.get(key));
			}
			
		}
	}
	
	public void getMyInfo(int key){
		new MyCache().getDetails(key);
	}
}


public class TestNested {
 public static void main(String[] args) {
	MyBox a = new MyBox(1, "Rajo");
	MyBox b = new MyBox(2, "Aditya");
	//MyBox.MyCache b = a.new MyCache();
	//b.getDetails();
	a.getMyInfo(2);
	b.getMyInfo(2);
}
}
