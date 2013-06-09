package com.malinovsky.kafedra.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.malinovskiy.kafedra.utils.BeanConverter;
import com.malinovsky.kafedra.model.CafeProduct;
import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.model.form.ReceptionProductForm;
import com.malinovsky.kafedra.model.form.WarekeeperBean;
import com.malinovsky.kafedra.service.CafeProductService;
import com.malinovsky.kafedra.service.CafeService;
import com.malinovsky.kafedra.service.EmployerService;
import com.malinovsky.kafedra.service.ProductService;

@Controller
@RequestMapping("/warekeeper")
public class WareKeeperController {
	private static final String WAREKEEPER_MAIN = "index/warekeeper/main";
	private static final String WAREKEEPER_LIST = "index/warekeeper/product-list";

	private static final String PRODUCT_FORM = "product_form";
	@Autowired
	private EmployerService employerService;
	@Autowired
	private CafeService cafeService;
	@Autowired
	private ProductService productService;
	@Autowired
	private CafeProductService cpService;

	@RequestMapping("/main")
	public String getMainView() {
		return WAREKEEPER_MAIN;
	}

	@RequestMapping("/product-list")
	public String getProductsView(Model m) {
		Employer e = employerService.getAuthenticatedEmployer();
		m.addAttribute(
				PRODUCT_FORM,
				new ReceptionProductForm(BeanConverter
						.convertToWarekeeperBeanList(e.getCafe().getProducts())));
		return WAREKEEPER_LIST;
	}

	@RequestMapping(value = "/product-list", method = RequestMethod.POST)
	public String postProductsView(
			@Valid @ModelAttribute(PRODUCT_FORM) ReceptionProductForm rpf,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(PRODUCT_FORM, rpf);
			return WAREKEEPER_LIST;
		}
		cpService.saveAll(updateCafeProductList(getChanged(rpf.getBeans())));
		return "redirect:/warekeeper/main.html";
	}

	private CafeProduct updateCafeProduct(WarekeeperBean bean) {
		CafeProduct result = cpService.findById(bean.getCafeProductId());
		result.setAvailableQuantity(bean.getAvailable() + bean.getAdded());
		return result;
	}

	private List<CafeProduct> updateCafeProductList(List<WarekeeperBean> list) {
		List<CafeProduct> result = new ArrayList<CafeProduct>();
		for (WarekeeperBean bean : list) {
			result.add(updateCafeProduct(bean));
		}
		return result;
	}

	private List<WarekeeperBean> getChanged(List<WarekeeperBean> all) {
		List<WarekeeperBean> result = new ArrayList<WarekeeperBean>();
		for (WarekeeperBean warekeeperBean : all) {
			if (warekeeperBean.getAdded() != null
					&& warekeeperBean.getAdded() > 0) {
				result.add(warekeeperBean);
			}
		}
		return result;

	}
}