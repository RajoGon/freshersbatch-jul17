package com.springmongo.collection;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;
@Entity
@Table(name="categories")
public class ItemCollection {
	@Id
	@Column(name="id")
	String id;
	@Column(name="name")
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
