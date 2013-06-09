package com.malinovsky.kafedra.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_PRICE_HISTORY")
public class ProductPriceRecord extends AbstractPriceRecord {
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	public ProductPriceRecord() {
	}

	public ProductPriceRecord(Product product, Date date, Double price) {
		setProduct(product);
		setDate(date);
		setValue(price);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
