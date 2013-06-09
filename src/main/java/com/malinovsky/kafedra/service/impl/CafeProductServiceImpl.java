package com.malinovsky.kafedra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malinovsky.kafedra.dao.CafeProductDao;
import com.malinovsky.kafedra.model.CafeProduct;
import com.malinovsky.kafedra.service.CafeProductService;
import com.nixsolutions.commons.service.impl.GenericServiceImpl;

@Service
public class CafeProductServiceImpl extends
		GenericServiceImpl<CafeProduct, Long, CafeProductDao> implements
		CafeProductService {
	@Autowired
	protected CafeProductServiceImpl(CafeProductDao dao) {
		super(dao);
	}

	@Override
	public void saveAll(List<CafeProduct> products) {
		for (CafeProduct cafeProduct : products) {
			dao.saveOrUpdate(cafeProduct);
		}
	}

}
