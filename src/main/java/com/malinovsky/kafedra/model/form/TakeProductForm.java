package com.malinovsky.kafedra.model.form;

import java.util.List;

import com.malinovsky.kafedra.model.CafeProduct;

public class TakeProductForm {
	private List<CafeProduct> products;

	public TakeProductForm() {
	}

	public TakeProductForm(List<CafeProduct> products) {
		setProducts(products);
	}

	public List<CafeProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CafeProduct> products) {
		this.products = products;
	}

}
