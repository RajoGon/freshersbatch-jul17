package com.enumtest;

enum Status { 
	NEW(1),REJECTED(2), ACCEPTED(3), COMPLETED(4);
		int value;
		Status(int value){
			this.value = value;
		}
	};
class OrderStatus{
	Status status;
	int orderid;
	String ordername;
	int price;
	int quantity;
	OrderStatus(Status status,int id, String name,int price,int quantity){
		this.status = status;
		this.orderid = id;
		this.ordername=name;
		this.price = price;
		this.quantity = quantity;		
	}
	public void printAll(){
		System.out.println("Status - "+status.value);
		System.out.println(orderid+"\n"+ordername+"\n"+price+"\n"+quantity);
	}
	
}
public class TestEnum {
	public static void main(String[] args) {
		OrderStatus a = new OrderStatus(Status.NEW, 1, "TV", 1500, 2);
		a.printAll();
	}
}