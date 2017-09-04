package com.springmongo.collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usersession")
public class UserLoginCollection {
	
	@Id
	@Column(name="authtoken")
	String id;
	@Column(name="username")
	String userName;
	@Column(name="lastUpdated")
	String lastUpdated;
	
	
	public UserLoginCollection(){}
	public UserLoginCollection(String id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	public String getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public UserLoginCollection(String id, String userName, String lastUpdated) {
		super();
		this.id = id;
		this.userName = userName;
		this.lastUpdated = lastUpdated;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	
}
