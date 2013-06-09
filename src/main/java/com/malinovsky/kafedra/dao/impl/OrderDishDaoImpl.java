package com.malinovsky.kafedra.dao.impl;

import org.springframework.stereotype.Repository;

import com.malinovsky.kafedra.dao.OrderDishDao;
import com.malinovsky.kafedra.model.OrderDish;
import com.nixsolutions.commons.db.dao.impl.GenericDaoHibernate;

@Repository
public class OrderDishDaoImpl extends GenericDaoHibernate<OrderDish, Long>
		implements OrderDishDao {

}
