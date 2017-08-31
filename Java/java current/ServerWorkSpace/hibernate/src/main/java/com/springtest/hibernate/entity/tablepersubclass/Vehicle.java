package com.springtest.hibernate.entity.tablepersubclass;

import javax.persistence.*;

@Entity
@Table(name="Vehicles")
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {
	@Id
	@GeneratedValue
	@Column(name="vid")
	private long id;
	private String colour;
	public Vehicle(long id, String colour) {
		super();
		this.id = id;
		this.colour = colour;
	}
	public Vehicle(String colour) {
		super();
		this.colour = colour;
	}
	public Vehicle() {
		super();
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", colour=" + colour + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
}
