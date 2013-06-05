package com.malinovsky.kafedra.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ORDER")
public class Order {
	@Id
	@Column(name = "ORDER_ID")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	@Column(name = "ORDER_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "CAFE_ID")
	private Cafe cafe;
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<OrderDish> dishes;

	public Order() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public Set<OrderDish> getDishes() {
		return dishes;
	}

	public void setDishes(Set<OrderDish> dishes) {
		this.dishes = dishes;
	}
}
