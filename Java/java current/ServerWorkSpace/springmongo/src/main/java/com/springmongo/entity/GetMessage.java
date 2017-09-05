package com.springmongo.entity;

public class GetMessage {
	int postId;
	String message;
	public GetMessage(){}
	public GetMessage(int postId, String message) {
		super();
		this.postId = postId;
		this.message = message;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
