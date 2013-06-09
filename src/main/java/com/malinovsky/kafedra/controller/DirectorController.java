package com.malinovsky.kafedra.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.malinovsky.kafedra.binder.VendorBinder;
import com.malinovsky.kafedra.model.Cafe;
import com.malinovsky.kafedra.model.CalculationType;
import com.malinovsky.kafedra.model.Dish;
import com.malinovsky.kafedra.model.DishPriceRedord;
import com.malinovsky.kafedra.model.DishProduct;
import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.model.Product;
import com.malinovsky.kafedra.model.ProductPriceRecord;
import com.malinovsky.kafedra.model.Vendor;
import com.malinovsky.kafedra.model.form.DishBean;
import com.malinovsky.kafedra.model.form.DishProductBean;
import com.malinovsky.kafedra.model.form.DishProductForm;
import com.malinovsky.kafedra.model.form.ProductBean;
import com.malinovsky.kafedra.service.CafeService;
import com.malinovsky.kafedra.service.DishService;
import com.malinovsky.kafedra.service.EmployerService;
import com.malinovsky.kafedra.service.ProductService;
import com.malinovsky.kafedra.service.VendorService;

@Controller
@RequestMapping("/director")
public class DirectorController {
	private static final String TYPE_LIST = "types";
	private static final String DIRECTOR_MAIN = "index/director/main";
	private static final String DIRECTOR_VENDOR_LIST = "index/director/vendor-list";
	private static final String DIRECTOR_VENDOR = "index/director/vendor";
	private static final String DIRECTOR_PRODUCT_LIST = "index/director/product-list";
	private static final String DIRECTOR_CAFE = "index/director/cafe";
	private static final String DIRECTOR_PRODUCT = "index/director/product";
	private static final String DIRECTOR_CAFE_LIST = "index/director/cafe-list";
	private static final String DIRECTOR_EMPLOYER_LIST = "index/director/employer-list";
	private static final String DIRECTOR_EMPLOYER = "index/director/employer";
	private static final String DIRECTOR_DISH_LIST = "index/director/dish-list";
	private static final String DIRECTOR_DISH = "index/director/dish";
	private static final String DIRECTOR_DISH_SET = "index/director/dish-set";
	private static final String CAFE_LIST = "cafe_list";
	private static final String VENDOR_LIST = "vendor_list";
	private static final String PRODUCT_LIST = "product_list";
	private static final String DISH_LIST = "dish_list";
	private static final String PRODUCT_BEAN = "product_bean";
	private static final String EMPLOYER_LIST = "employer_list";
	private static final String VENDOR_BEAN = "vendor_bean";
	private static final String CAFE_BEAN = "cafe_bean";
	private static final String DISH_BEAN = "dish_bean";
	private static final String DISH_SET_FORM = "dish_form";
	private static final String EMPLOYER_BEAN = "employer_bean";

	@Autowired
	private CafeService cafeService;
	@Autowired
	private EmployerService employerService;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private ProductService productService;
	@Autowired
	private DishService dishService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Vendor.class, new VendorBinder());
	}

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

	@RequestMapping(value = "/product", params = { "id" })
	public String doEditProductView(@RequestParam Long id, Model model) {
		model.addAttribute(PRODUCT_BEAN,
				new ProductBean(productService.findById(id)));
		model.addAttribute(VENDOR_LIST, vendorService.getAll());
		model.addAttribute(TYPE_LIST, CalculationType.values());
		return DIRECTOR_PRODUCT;
	}

	@RequestMapping(value = "/product")
	public String doProductView(Model model) {
		model.addAttribute(PRODUCT_BEAN, new ProductBean());
		model.addAttribute(VENDOR_LIST, vendorService.getAll());
		model.addAttribute(TYPE_LIST, CalculationType.values());
		return DIRECTOR_PRODUCT;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute(PRODUCT_BEAN) ProductBean bean,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(PRODUCT_BEAN, bean);
			model.addAttribute(VENDOR_LIST, vendorService.getAll());
			model.addAttribute(TYPE_LIST, CalculationType.values());
			return DIRECTOR_PRODUCT;
		}
		Product pr = new Product(bean);
		pr.getPrices().add(
				new ProductPriceRecord(pr, new Date(), bean.getPrice()));
		productService.saveOrUpdate(pr);
		return "redirect:/director/product-list.html";
	}

	@RequestMapping(value = "/product-list")
	public String doVendorProductView(Model model) {
		model.addAttribute(PRODUCT_LIST,
				getProductBeans(productService.getAll()));
		return DIRECTOR_PRODUCT_LIST;
	}

	@RequestMapping(value = "/saveVendor", method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute Vendor vendor,
			BindingResult errors, Model model) {
		vendorService.saveOrUpdate(vendor);
		return "redirect:/director/vendor-list.html";
	}

	@RequestMapping(value = "/dish-list")
	public String doDishListView(Model model) {
		model.addAttribute(DISH_LIST, getDishBeans(dishService.getAll()));
		return DIRECTOR_DISH_LIST;
	}

	@RequestMapping(value = "/dish")
	public String doNewDishView(Model model) {
		model.addAttribute(DISH_BEAN, new DishBean());
		return DIRECTOR_DISH;
	}

	@RequestMapping(value = "/dish", params = { "id" })
	public String doEditDishView(@RequestParam Long id, Model model) {
		model.addAttribute(DISH_BEAN, new DishBean(dishService.findById(id)));
		return DIRECTOR_DISH;
	}

	@RequestMapping(value = "/saveDish", method = RequestMethod.POST)
	public String doEditDishView(@ModelAttribute("dish_bean") DishBean bean,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(DISH_BEAN, bean);
			return DIRECTOR_DISH;
		}
		Dish dish = new Dish(bean);
		dish.getPrices().add(
				new DishPriceRedord(dish, new Date(), bean.getPrice()));
		dishService.saveOrUpdate(dish);
		return "redirect:/director/dish-list.html";
	}

	@RequestMapping(value = "/dish-set", params = { "id" })
	public String doDishSetView(@RequestParam Long id, Model model) {
		Dish d = dishService.findById(id);
		DishProductForm dpf = new DishProductForm(id,
				getDishProducts(d.getIngradients()));
		model.addAttribute(DISH_SET_FORM, dpf);
		return DIRECTOR_DISH_SET;
	}

	@RequestMapping(value = "/saveDishSet.html", method = RequestMethod.POST)
	public String saveDishSetView(
			@ModelAttribute("dish_form") DishProductForm dpf, Model model) {
		model.addAttribute(DISH_SET_FORM, dpf);
		return DIRECTOR_DISH_SET;
	}

	@RequestMapping(value = "/addProduct.html", method = RequestMethod.POST)
	public String addProductToDish(
			@ModelAttribute("dish_form") DishProductForm dpf, Model model) {
		model.addAttribute(DISH_SET_FORM, dpf);
		return DIRECTOR_DISH_SET;
	}

	@RequestMapping(value = "/removeProduct.html", method = RequestMethod.POST)
	public String removeProduct(
			@ModelAttribute("dish_form") DishProductForm dpf, Model model) {
		model.addAttribute(DISH_SET_FORM, dpf);
		return DIRECTOR_DISH_SET;
	}

	private List<ProductBean> getProductBeans(List<Product> products) {
		List<ProductBean> result = new ArrayList<ProductBean>();
		for (Product product : products) {
			result.add(new ProductBean(product));
		}
		return result;
	}

	private List<DishBean> getDishBeans(List<Dish> dishes) {
		List<DishBean> result = new ArrayList<DishBean>();
		for (Dish dish : dishes) {
			result.add(new DishBean(dish));
		}
		return result;
	}

	private List<DishProductBean> getDishProducts(List<DishProduct> ingradients) {
		List<DishProductBean> result = new ArrayList<DishProductBean>();
		for (DishProduct dish : ingradients) {
			result.add(new DishProductBean(dish));
		}
		return result;
	}
}
