package com.malinovsky.kafedra.model.form;

import java.util.List;

public class DishProductForm {
	private long dishId;
	private List<DishProductBean> products;

	public DishProductForm() {

	}

	public DishProductForm(Long id, List<DishProductBean> beans) {
		setDishId(id);
		setProducts(beans);
	}

	public List<DishProductBean> getProducts() {
		return products;
	}

	public void setProducts(List<DishProductBean> products) {
		this.products = products;
	}

	public long getDishId() {
		return dishId;
	}

	public void setDishId(long dishId) {
		this.dishId = dishId;
	}
}
