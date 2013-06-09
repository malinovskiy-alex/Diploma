package com.malinovsky.kafedra.service;

import java.util.List;

import com.malinovsky.kafedra.dao.CafeProductDao;
import com.malinovsky.kafedra.model.CafeProduct;
import com.nixsolutions.commons.service.GenericService;

public interface CafeProductService extends
		GenericService<CafeProduct, Long, CafeProductDao> {
	void saveAll(List<CafeProduct> products);
}
