package com.malinovsky.kafedra.model;

import java.util.Date;

public class PriceRecord {
	private long id;
	private Double price;
	private Date date;

	public PriceRecord() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
