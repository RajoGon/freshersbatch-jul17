package com.springmongo.entity;

public class UpdateAd {
	int postId;
	String status;
	String name;
	String title;
	String description;
	String category;
	public UpdateAd(){}
	public UpdateAd(int postId, String status, String name, String title, String description, String category) {
		super();
		this.postId = postId;
		this.status = status;
		this.name = name;
		this.title = title;
		this.description = description;
		this.category = category;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "UpdateAd [postId=" + postId + ", status=" + status + ", name=" + name + ", title=" + title
				+ ", description=" + description + ", category=" + category + "]";
	}
	
}
