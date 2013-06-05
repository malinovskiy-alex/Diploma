package com.malinovsky.kafedra.model;

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

@Entity
@Table(name = "CAFE")
public class Cafe {
	@Id
	@Column(name = "CAFE_ID")
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	@Column(name = "ADDRESS", length = 80)
	private String address;
	@Column(name = "PHONE", length = 14)
	private String phone;
	@Column(name = "PLACE_COUNT", length = 4)
	private Integer placeCount;
	@OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employer> employers;
	@OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Order> orders;
	@OneToMany(mappedBy = "cafe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CafeProduct> products;

	public Cafe() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPlaceCount() {
		return placeCount;
	}

	public void setPlaceCount(Integer placeCount) {
		this.placeCount = placeCount;
	}

	public List<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<CafeProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CafeProduct> products) {
		this.products = products;
	}

}
