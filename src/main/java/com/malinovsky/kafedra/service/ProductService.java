package com.malinovsky.kafedra.service;

import com.malinovsky.kafedra.dao.ProductDao;
import com.malinovsky.kafedra.model.Product;
import com.nixsolutions.commons.service.GenericService;

public interface ProductService extends
		GenericService<Product, Long, ProductDao> {

}
