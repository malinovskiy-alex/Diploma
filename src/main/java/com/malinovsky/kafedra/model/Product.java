package com.malinovsky.kafedra.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;

@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@Column(name = "PRODUCT_ID")
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
	@OrderBy(clause="date")
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProductPriceRecord> prices;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DishProduct> dishes;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

	public List<ProductPriceRecord> getPrices() {
		return prices;
	}

	public void setPrices(List<ProductPriceRecord> prices) {
		this.prices = prices;
	}

	public double getPrice() {
		return prices.get(prices.size() - 1).getPrice();
	}
}
