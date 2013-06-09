package com.malinovsky.kafedra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malinovsky.kafedra.dao.OrderDao;
import com.malinovsky.kafedra.model.Order;
import com.malinovsky.kafedra.service.OrderService;
import com.nixsolutions.commons.service.impl.GenericServiceImpl;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order, Long, OrderDao>
		implements OrderService {
	@Autowired
	protected OrderServiceImpl(OrderDao dao) {
		super(dao);
	}

}
