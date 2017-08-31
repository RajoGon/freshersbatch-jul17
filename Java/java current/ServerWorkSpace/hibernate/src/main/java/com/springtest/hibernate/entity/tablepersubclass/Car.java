package com.springtest.hibernate.entity.tablepersubclass;

import javax.persistence.*;
@Entity
@Table(name="Car")
@PrimaryKeyJoinColumn(name="id")
public class Car extends Vehicle {
	@Column(name="engine")
	private String engine;

	public Car(long id, String colour, String engine) {
		super(id, colour);
		this.engine = engine;
	}
	public Car( String colour, String engine) {
		super(colour);
		this.engine = engine;
	}
	public Car(String engine) {
		super();
		this.engine = engine;
	}
	public Car(long id, String colour) {
		super(id, colour);
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	@Override
	public String toString() {
		return "Car [engine=" + engine + "]";
	}
	
	
	
}