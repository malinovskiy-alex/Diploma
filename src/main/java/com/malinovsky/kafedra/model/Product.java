package com.malinovsky.kafedra.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@Column(name = "CAFE_ID")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "CALCULATION_TYPE")
	@Enumerated(EnumType.STRING)
	private CalculationType type;
	@ManyToOne
	@JoinColumn(name = "VENDOR_ID")
	private Vendor vendor;
	private Set<PriceRecord> prices;
	private Set<DishProduct> dishes;
	private Set<CafeProduct> cafes;

	public Product() {

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

	public Set<DishProduct> getDishes() {
		return dishes;
	}

	public void setDishes(Set<DishProduct> dishes) {
		this.dishes = dishes;
	}

	public Set<CafeProduct> getCafes() {
		return cafes;
	}

	public void setCafes(Set<CafeProduct> cafes) {
		this.cafes = cafes;
	}

	public Set<PriceRecord> getPrices() {
		return prices;
	}

	public void setPrices(Set<PriceRecord> prices) {
		this.prices = prices;
	}

}
