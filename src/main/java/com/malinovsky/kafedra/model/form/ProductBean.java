package com.malinovsky.kafedra.model.form;

import com.malinovsky.kafedra.model.CalculationType;
import com.malinovsky.kafedra.model.Product;
import com.malinovsky.kafedra.model.Vendor;

public class ProductBean {
	private long id;
	private String name;
	private CalculationType type;
	private Vendor vendor;
	private Double price;

	public ProductBean() {
	}

	public ProductBean(Product product) {
		setId(product.getId());
		setName(product.getName());
		setType(product.getType());
		setVendor(product.getVendor());
		setPrice(product.getPrice());
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

	public CalculationType getType() {
		return type;
	}

	public void setType(CalculationType type) {
		this.type = type;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
