package com.springmongo.collection;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Items")
public class ItemCollection {
	String id;
	String name;
	public ItemCollection(){}
	public ItemCollection(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	 
}
