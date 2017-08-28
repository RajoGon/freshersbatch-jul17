package com.springtest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ChatRoom {
	private String name;
	private HashSet<String> users = new HashSet<String>();
	private ArrayList<String> messages = new ArrayList<String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashSet<String> getUsers() {
		return users;
	}
	public void setUsers(HashSet<String> users) {
		this.users = users;
	}
	public ArrayList<String> getMessages() {
		return messages;
	}
	public void setMessages(ArrayList<String> messages) {
		this.messages = messages;
	}
	
}
