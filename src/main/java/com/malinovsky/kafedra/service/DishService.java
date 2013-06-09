package com.malinovsky.kafedra.service;

import com.malinovsky.kafedra.dao.DishDao;
import com.malinovsky.kafedra.model.Dish;
import com.nixsolutions.commons.service.GenericService;

public interface DishService extends GenericService<Dish, Long, DishDao> {

}
