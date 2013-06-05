package com.malinovsky.kafedra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.malinovsky.kafedra.model.Cafe;
import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.model.Vendor;
import com.malinovsky.kafedra.service.CafeService;
import com.malinovsky.kafedra.service.EmployerService;
import com.malinovsky.kafedra.service.VendorService;

@Controller
@RequestMapping("/director")
public class DirectorController {
	private static final String DIRECTOR_MAIN = "index/director/main";
	private static final String DIRECTOR_VENDOR_LIST = "index/director/vendor-list";
	private static final String DIRECTOR_VENDOR = "index/director/vendor";
	private static final String DIRECTOR_PRODUCT_LIST = "index/director/product-list";
	private static final String DIRECTOR_CAFE = "index/director/cafe";
	private static final String DIRECTOR_CAFE_LIST = "index/director/cafe-list";
	private static final String DIRECTOR_EMPLOYER_LIST = "index/director/employer-list";
	private static final String DIRECTOR_EMPLOYER = "index/director/employer";
	private static final String CAFE_LIST = "cafe_list";
	private static final String VENDOR_LIST = "vendor_list";
	private static final String PRODUCT_LIST = "product_list";
	private static final String EMPLOYER_LIST = "employer_list";
	private static final String VENDOR_BEAN = "vendor_bean";
	private static final String CAFE_BEAN = "cafe_bean";
	private static final String EMPLOYER_BEAN = "employer_bean";

	@Autowired
	private CafeService cafeService;
	@Autowired
	private EmployerService employerService;
	@Autowired
	private VendorService vendorService;

	@RequestMapping("/main")
	public String doDirectorView() {
		return DIRECTOR_MAIN;
	}

	@RequestMapping("/vendor-list")
	public String doVendorListView(Model model) {
		model.addAttribute(VENDOR_LIST, vendorService.getAll());
		return DIRECTOR_VENDOR_LIST;
	}

	@RequestMapping("/cafe-list")
	public String doCafeListView(Model model) {
		model.addAttribute(CAFE_LIST, cafeService.getAll());
		return DIRECTOR_CAFE_LIST;
	}

	@RequestMapping(value = "/employer-list", params = { "cafe" })
	public String doEmployerListView(@RequestParam Long cafe, Model model) {
		model.addAttribute(EMPLOYER_LIST, employerService.findByCafeId(cafe));
		return DIRECTOR_EMPLOYER_LIST;
	}

	@RequestMapping(value = "/cafe", params = { "id" })
	public String doEditCafeView(@RequestParam Long id, Model model) {
		model.addAttribute(CAFE_BEAN, cafeService.findById(id));
		return DIRECTOR_CAFE;
	}

	@RequestMapping(value = "/cafe")
	public String doNewCafeView(Model model) {
		model.addAttribute(CAFE_BEAN, new Cafe());
		return DIRECTOR_CAFE;
	}

	@RequestMapping(value = "/saveCafe", method = RequestMethod.POST)
	public String saveCafe(@ModelAttribute Cafe cafe, BindingResult errors,
			Model model) {
		cafeService.saveOrUpdate(cafe);
		return "redirect:/director/cafe-list.html";
	}

	@RequestMapping(value = "/employer", params = { "id" })
	public String doEditEmployerView(@RequestParam Long id, Model model) {
		model.addAttribute(EMPLOYER_BEAN, employerService.findById(id));
		return DIRECTOR_EMPLOYER;
	}

	@RequestMapping(value = "/employer")
	public String doNewEmployerView(Model model) {
		model.addAttribute(EMPLOYER_BEAN, new Employer());
		return DIRECTOR_EMPLOYER;
	}

	@RequestMapping(value = "/saveEmployer", method = RequestMethod.POST)
	public String saveEmployer(@ModelAttribute Employer employer,
			BindingResult errors, Model model) {
		employerService.saveOrUpdate(employer);
		return "redirect:/director/employer-list.html";
	}

	@RequestMapping(value = "/vendor", params = { "id" })
	public String doEditVendorView(@RequestParam Long id, Model model) {
		model.addAttribute(VENDOR_BEAN, vendorService.findById(id));
		return DIRECTOR_VENDOR;
	}

	@RequestMapping(value = "/vendor")
	public String doNewVendorView(Model model) {
		model.addAttribute(VENDOR_BEAN, new Vendor());
		return DIRECTOR_VENDOR;
	}

	@RequestMapping(value = "/product-list", params = { "id" })
	public String doVendorProductView(@RequestParam Long id, Model model) {
		model.addAttribute(PRODUCT_LIST, vendorService.findById(id)
				.getProducts());
		return DIRECTOR_PRODUCT_LIST;
	}

	@RequestMapping(value = "/saveVendor", method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute Vendor vendor,
			BindingResult errors, Model model) {
		vendorService.saveOrUpdate(vendor);
		return "redirect:/director/vendor-list.html";
	}
}
