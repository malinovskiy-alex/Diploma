package com.malinovsky.kafedra.service;

import com.malinovsky.kafedra.dao.OrderDao;
import com.malinovsky.kafedra.model.Order;
import com.nixsolutions.commons.service.GenericService;

public interface OrderService extends GenericService<Order, Long, OrderDao> {
}
