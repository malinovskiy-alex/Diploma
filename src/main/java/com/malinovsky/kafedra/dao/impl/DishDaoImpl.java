package com.malinovsky.kafedra.dao.impl;

import org.springframework.stereotype.Repository;

import com.malinovsky.kafedra.dao.DishDao;
import com.malinovsky.kafedra.model.Dish;
import com.nixsolutions.commons.db.dao.impl.GenericDaoHibernate;

@Repository
public class DishDaoImpl extends GenericDaoHibernate<Dish, Long> implements
		DishDao {

}
