package com.malinovsky.kafedra.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OrderBy;

import com.malinovsky.kafedra.model.form.DishBean;

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
	@OrderBy(clause = "date")
	@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DishPriceRedord> prices = new ArrayList<DishPriceRedord>();
	@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<DishProduct> ingradients = new ArrayList<DishProduct>();
	@OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderDish> orders = new ArrayList<OrderDish>();

	public Dish() {
	}

	public Dish(DishBean dish) {
		setId(dish.getId());
		setName(dish.getName());
		setDesc(dish.getDescription());
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

	public List<DishPriceRedord> getPrices() {
		return prices;
	}

	public void setPrices(List<DishPriceRedord> prices) {
		this.prices = prices;
	}

	public double getPrice() {
		return prices.get(prices.size() - 1).getValue();
	}

	public List<DishProduct> getIngradients() {
		return ingradients;
	}

	public void setIngradients(List<DishProduct> ingradients) {
		this.ingradients = ingradients;
	}

	public List<OrderDish> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderDish> orders) {
		this.orders = orders;
	}
}
