package com.malinovsky.kafedra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malinovsky.kafedra.dao.VendorDao;
import com.malinovsky.kafedra.model.Vendor;
import com.malinovsky.kafedra.service.VendorService;
import com.nixsolutions.commons.service.impl.GenericServiceImpl;

@Service
public class VendorServiceImpl extends
		GenericServiceImpl<Vendor, Long, VendorDao> implements VendorService {
	@Autowired
	protected VendorServiceImpl(VendorDao dao) {
		super(dao);
	}

}
