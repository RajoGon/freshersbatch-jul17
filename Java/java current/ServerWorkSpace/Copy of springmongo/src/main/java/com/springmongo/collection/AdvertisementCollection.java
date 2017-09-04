package com.springmongo.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Advertisements")
public class AdvertisementCollection {
	@Id
	String id;
	String name;
	String title;
	String description;
	String categoryl;
	public AdvertisementCollection(){}
	public AdvertisementCollection(String id, String name, String title, String description, String categoryl) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.description = description;
		this.categoryl = categoryl;
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
	public String getCategoryl() {
		return categoryl;
	}
	public void setCategoryl(String categoryl) {
		this.categoryl = categoryl;
	}
	@Override
	public String toString() {
		return "AdvertisementCollection [id=" + id + ", name=" + name + ", title=" + title + ", description="
				+ description + ", categoryl=" + categoryl + "]";
	}
	
}
