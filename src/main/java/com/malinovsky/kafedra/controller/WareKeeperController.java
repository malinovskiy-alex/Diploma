package com.malinovsky.kafedra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.model.form.TakeProductForm;
import com.malinovsky.kafedra.service.EmployerService;

@Controller
@RequestMapping("/warekeeper")
public class WareKeeperController {
	private static final String WAREKEEPER_MAIN = "index/warekeeper/main";
	private static final String PRODUCT_FORM = "product_form";
	@Autowired
	private EmployerService employerService;

	@RequestMapping("/main")
	public String getMainView(Model m) {
		Employer e = employerService.getAuthenticatedEmployer();
		m.addAttribute(PRODUCT_FORM, new TakeProductForm(e.getCafe()
				.getProducts()));
		return WAREKEEPER_MAIN;
	}

	@RequestMapping(value = "/main", method = RequestMethod.POST)
	public String postMainView(@ModelAttribute TakeProductForm tf) {
	
		return WAREKEEPER_MAIN;
	}

}
