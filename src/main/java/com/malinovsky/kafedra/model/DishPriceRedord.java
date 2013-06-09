package com.malinovsky.kafedra.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DISH_PRICE_HISTORY")
public class DishPriceRedord extends AbstractPriceRecord {
	@ManyToOne
	@JoinColumn(name = "DISH_ID")
	private Dish dish;

	public DishPriceRedord() {
	}

	public DishPriceRedord(Dish dish, Date date, Double price) {
		setDish(dish);
		setDate(date);
		setValue(price);
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}
}
