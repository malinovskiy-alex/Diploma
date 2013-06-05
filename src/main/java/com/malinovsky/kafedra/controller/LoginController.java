package com.malinovsky.kafedra.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.service.EmployerService;

@Controller
public class LoginController {
	private static final Logger LOG = LoggerFactory
			.getLogger(LoginController.class);
	public static final String AUTH_EMPLOYER_BEAN = "auth_employer";
	@Autowired
	private EmployerService employerService;

	@RequestMapping(value = "/authenticate")
	public String doIndex() {
		LOG.debug("Authenticate works!!");
		Employer e = employerService.getAuthenticatedEmployer();
		return "redirect:/" + e.getRole().getName() + "/main.html";
	}
}
