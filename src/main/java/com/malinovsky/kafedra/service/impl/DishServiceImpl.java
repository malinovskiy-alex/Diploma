package com.malinovsky.kafedra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malinovsky.kafedra.dao.DishDao;
import com.malinovsky.kafedra.model.Dish;
import com.malinovsky.kafedra.service.DishService;
import com.nixsolutions.commons.service.impl.GenericServiceImpl;

@Service
public class DishServiceImpl extends GenericServiceImpl<Dish, Long, DishDao>
		implements DishService {
	@Autowired
	protected DishServiceImpl(DishDao dao) {
		super(dao);
	}

}
