package com.malinovsky.kafedra.dao.impl.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.model.Order;
import com.malinovsky.kafedra.model.OrderDish;
import com.malinovsky.kafedra.service.DishService;
import com.malinovsky.kafedra.service.EmployerService;
import com.malinovsky.kafedra.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class OrderServiceImplTest {
	@Autowired
	private OrderService orderService;
	@Autowired
	private EmployerService employerSrevice;
	@Autowired
	private DishService dishSrevice;

	@Test
	public void testSaveOrder() {
		Employer e = employerSrevice.findById(3l);
		Order o = new Order();
		assertEquals(0, e.getCafe().getOrders().size());
		o.setCafe(e.getCafe());
		o.setDate(new Date());
		o.setDishes(generateOrderDish(o));
		orderService.saveOrUpdate(o);
		assertEquals(1, e.getCafe().getOrders().size());
	}

	private List<OrderDish> generateOrderDish(Order order) {
		List<OrderDish> dishes = new ArrayList<OrderDish>();
		dishes.add(new OrderDish(order, dishSrevice.findById(3l), 2));
		return dishes;
	}
}
