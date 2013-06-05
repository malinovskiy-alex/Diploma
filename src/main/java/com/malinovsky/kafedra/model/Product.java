package com.malinovsky.kafedra.model;

import java.util.Set;

public class Product {
	private long id;
	private String name;
	private CalculationType type;
	private Vendor vendor;
	private Double priceByOne;

	public Double getPriceByOne() {
		return priceByOne;
	}

	public void setPriceByOne(Double priceByOne) {
		this.priceByOne = priceByOne;
	}

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
