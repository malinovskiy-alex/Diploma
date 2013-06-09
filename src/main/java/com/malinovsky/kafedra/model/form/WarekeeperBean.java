package com.malinovsky.kafedra.model.form;

import com.malinovsky.kafedra.model.CalculationType;

public class WarekeeperBean {
	private long cafeProductId;
	private String name;
	private CalculationType type;
	private Double price;
	private Double available;
	private Double added;

	public WarekeeperBean() {
	}

	public Double getPrice() {
		return price;
	}

	public long getCafeProductId() {
		return cafeProductId;
	}

	public void setCafeProductId(long cafeProductId) {
		this.cafeProductId = cafeProductId;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CalculationType getType() {
		return type;
	}

	public void setType(CalculationType type) {
		this.type = type;
	}

	public Double getAvailable() {
		return available;
	}

	public void setAvailable(Double available) {
		this.available = available;
	}

	public Double getAdded() {
		return added;
	}

	public void setAdded(Double added) {
		this.added = added;
	}

}
