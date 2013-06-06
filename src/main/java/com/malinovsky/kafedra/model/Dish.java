package com.malinovsky.kafedra.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DISH")
public class Dish {
	@Id
	@Column(name = "DISH_ID")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	@Column(name = "NAME", length = 50)
	private String name;
	@Column(name = "WEIGHT")
	private Integer weight;
	@Column(name = "DESCRIPTION")
	private String desc;
	@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<PriceRecord> prices;
	@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<DishProduct> ingradients;
	@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<OrderDish> orders;

	public Dish() {
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

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Set<DishProduct> getIngradients() {
		return ingradients;
	}

	public void setIngradients(Set<DishProduct> ingradients) {
		this.ingradients = ingradients;
	}

	public Set<OrderDish> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderDish> orders) {
		this.orders = orders;
	}

	/*
	 * public Set<PriceRecord> getPrices() { return prices; }
	 * 
	 * public void setPrices(Set<PriceRecord> prices) { this.prices = prices; }
	 */

}
