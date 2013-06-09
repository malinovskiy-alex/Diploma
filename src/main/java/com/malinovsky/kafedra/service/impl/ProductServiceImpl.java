package com.malinovsky.kafedra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malinovsky.kafedra.dao.ProductDao;
import com.malinovsky.kafedra.model.Product;
import com.malinovsky.kafedra.model.form.ReceptionProductForm;
import com.malinovsky.kafedra.service.CafeService;
import com.malinovsky.kafedra.service.ProductService;
import com.nixsolutions.commons.service.impl.GenericServiceImpl;

@Service
public class ProductServiceImpl extends
		GenericServiceImpl<Product, Long, ProductDao> implements ProductService {
	@Autowired
	private CafeService cafeService;

	@Autowired
	protected ProductServiceImpl(ProductDao dao) {
		super(dao);
	}

	public void applyProducts(ReceptionProductForm rpf) {

	}
}
