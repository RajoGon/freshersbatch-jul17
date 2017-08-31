package com.springtest.hibernate.entity.mapstock;

import javax.persistence.*;

@Entity
@Table(name="STOCK")
public class Stock {
	@Id
	@GeneratedValue
	@Column(name="sid")
	private long id;
	@Column(name="price")
	private long price;
	
	
	public Stock(long price) {
		super();
		this.price = price;
	}
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="m_id")
	private Market market;
	
	@Override
	public String toString() {
		return "Stock [id=" + id + ", price=" + price + "]";
	}
	public Stock(){}
	public Stock(long price, Market market) {
		super();
		this.price = price;
		this.market = market;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public Market getMarket_id() {
		return market;
	}
	public void setMarket_id(Market market) {
		this.market = market;
	}
	
}
