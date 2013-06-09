package com.malinovsky.kafedra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malinovsky.kafedra.dao.OrderDishDao;
import com.malinovsky.kafedra.model.OrderDish;
import com.malinovsky.kafedra.service.OrderDishService;
import com.nixsolutions.commons.service.impl.GenericServiceImpl;

@Service
public class OrderDishServiceImpl extends GenericServiceImpl<OrderDish, Long, OrderDishDao>
		implements OrderDishService {
	@Autowired
	protected OrderDishServiceImpl(OrderDishDao dao) {
		super(dao);
	}

}
