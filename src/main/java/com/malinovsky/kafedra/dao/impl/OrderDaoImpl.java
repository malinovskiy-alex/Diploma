package com.malinovsky.kafedra.dao.impl;

import org.springframework.stereotype.Repository;

import com.malinovsky.kafedra.dao.OrderDao;
import com.malinovsky.kafedra.model.Order;
import com.nixsolutions.commons.db.dao.impl.GenericDaoHibernate;

@Repository
public class OrderDaoImpl extends GenericDaoHibernate<Order, Long> implements
		OrderDao {

}
