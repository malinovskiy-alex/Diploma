package com.malinovsky.kafedra.model.form;

import com.malinovsky.kafedra.model.DishProduct;

public class DishProductBean {
	private long productId;
	private String productName;
	private Double weight;

	public DishProductBean() {

	}

	public DishProductBean(DishProduct dp) {
		setProductId(dp.getProduct().getId());
		setProductName(dp.getProduct().getName());
		setWeight(dp.getProductWeight());
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
}
