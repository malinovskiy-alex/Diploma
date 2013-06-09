package com.malinovsky.kafedra.binder;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.malinovsky.kafedra.model.Dish;
import com.malinovsky.kafedra.service.DishService;
import com.malinovsky.kafedra.service.EmployerService;

@Component
public class DishBinder extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Dish dish = null;
		if (!text.isEmpty()) {
			dish = getDishService().findById(Long.valueOf(text));
		}
		setValue(dish);
	}

	private DishService getDishService() {
		HttpServletRequest request = (HttpServletRequest) RequestContextHolder
				.getRequestAttributes().resolveReference(
						RequestAttributes.REFERENCE_REQUEST);
		return (DishService) WebApplicationContextUtils
				.getWebApplicationContext(
						request.getSession().getServletContext()).getBean(
						"dishServiceImpl");
	}
}
