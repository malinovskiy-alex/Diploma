package com.malinovsky.kafedra.model.form;

import java.util.ArrayList;
import java.util.List;

public class OrderForm {
	private List<OrderBean> orders = new ArrayList<OrderBean>();

	public OrderForm() {
	}

	public List<OrderBean> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderBean> orders) {
		this.orders = orders;
	}

	public Double getTotalPrice() {
		double sum = 0;
		for (OrderBean bean : orders) {
			sum += bean.getTotalPrice();
		}
		return sum;
	}
}
