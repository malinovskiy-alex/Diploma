package com.malinovsky.kafedra.model.form;

import com.malinovsky.kafedra.model.Dish;

public class DishBean {
	private long id;
	private String name;
	private String description;
	private Double price;

	public DishBean() {

	}

	public DishBean(Dish dish) {
		setId(dish.getId());
		setName(dish.getName());
		setDescription(dish.getDesc());
		setPrice(dish.getPrice());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
