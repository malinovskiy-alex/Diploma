package com.malinovsky.kafedra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CAFE_PRODUCT")
public class CafeProduct {
	@Id
	@Column(name = "CAFE_PRODUCT_ID")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	@ManyToOne
	@JoinColumn(name = "CAFE_ID")
	private Cafe cafe;
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;
	@Column(name = "AVAILABLE_QUANTITY")
	private Double availableQuantity;
	@Column(name = "MARGINAL_QUANTITY")
	private Double marginalQuantity;
	@Column(name = "ORDER_QUANTITY")
	private Double orderQuantity;

	public CafeProduct() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Double availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Double getMarginalQuantity() {
		return marginalQuantity;
	}

	public void setMarginalQuantity(Double marginalQuantity) {
		this.marginalQuantity = marginalQuantity;
	}

	public Double getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Double orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

}
