package com.malinovsky.kafedra.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.malinovsky.kafedra.binder.DishBinder;
import com.malinovsky.kafedra.model.Dish;
import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.model.Order;
import com.malinovsky.kafedra.model.OrderDish;
import com.malinovsky.kafedra.model.form.OrderBean;
import com.malinovsky.kafedra.model.form.OrderForm;
import com.malinovsky.kafedra.service.DishService;
import com.malinovsky.kafedra.service.EmployerService;
import com.malinovsky.kafedra.service.OrderDishService;
import com.malinovsky.kafedra.service.OrderService;

@Controller
@RequestMapping("/waiter")
public class WaiterController {
	private static final String WAITER_MAIN = "index/waiter/main";
	private static final String WAITER_ORDER = "index/waiter/order";
	private static final String DISH_BEAN = "dish_bean";
	private static final String ORDER_FORM = "order_form";
	private static final String DISH_LIST = "dish_list";
	@Autowired
	private DishService dishService;
	@Autowired
	private EmployerService employerService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDishService orderDishService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Dish.class, new DishBinder());
	}

	@RequestMapping("/main")
	public String getMainView() {
		return WAITER_MAIN;
	}

	@RequestMapping("/order")
	public String getOrderView(Model m) {
		m.addAttribute(DISH_BEAN, new OrderBean());
		m.addAttribute(DISH_LIST, dishService.getAll());
		m.addAttribute(ORDER_FORM, new OrderForm());
		return WAITER_ORDER;
	}

	@RequestMapping(value = "/addDish", method = RequestMethod.POST)
	public String addDish(@ModelAttribute("order_form") OrderForm form,
			@RequestParam Integer count, @RequestParam Long dishId,
			HttpServletRequest request) {
		OrderBean order = new OrderBean();
		Dish d = dishService.findById(dishId);
		order.setCount(count);
		order.setDishId(dishId);
		order.setDishName(d.getName());
		order.setDishPrice(d.getPrice());
		order.setTotalPrice(d.getPrice() * order.getCount());
		form.getOrders().add(order);
		request.setAttribute(DISH_LIST, dishService.getAll());
		request.setAttribute(ORDER_FORM, form);
		return WAITER_ORDER;
	}

	@RequestMapping(value = "/removeDish", method = RequestMethod.POST, params = { "pos" })
	public String removeDish(@ModelAttribute("order_form") OrderForm form,
			@RequestParam Integer pos, HttpServletRequest request) {
		request.setAttribute(DISH_LIST, dishService.getAll());
		form.getOrders().remove(form.getOrders().get(pos));
		request.setAttribute(ORDER_FORM, form);
		return WAITER_ORDER;
	}

	@RequestMapping(value = "/saveOrder.html", method = RequestMethod.POST)
	public String postOrder(@ModelAttribute OrderForm form, Model m) {
		Employer e = employerService.getAuthenticatedEmployer();
		Order o = new Order();
		o.setDishes(getOrderStructure(form.getOrders(), o));
		o.setCafe(e.getCafe());
		o.setDate(new Date());
		orderService.saveOrUpdate(o);
		return "redirect:/waiter/main.html";
	}

	private List<OrderDish> getOrderStructure(List<OrderBean> beans, Order order) {
		List<OrderDish> result = new ArrayList<OrderDish>();
		for (OrderBean bean : beans) {
			result.add(new OrderDish(order, dishService.findById(bean
					.getDishId()), bean.getCount()));
		}
		return result;
	}
}
