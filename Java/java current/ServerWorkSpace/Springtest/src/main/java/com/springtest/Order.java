package com.springtest;

public class Order {
	private Item item;
	private String name;
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Order [item=" + item + ", name=" + name + "]";
	}	
}
