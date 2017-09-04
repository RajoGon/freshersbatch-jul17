package com.springmongo.collection;

import javax.persistence.*;



@Entity
@Table(name="Actions")
public class ActionCollection {
	@Id
	@Column(name="id")
	String id;
	@Column(name="name")
	String name;
	public ActionCollection(){}
	public ActionCollection(String id, String name) {
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
