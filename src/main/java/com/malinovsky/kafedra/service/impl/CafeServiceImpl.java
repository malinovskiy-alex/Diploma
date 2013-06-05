package com.malinovsky.kafedra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malinovsky.kafedra.dao.CafeDao;
import com.malinovsky.kafedra.model.Cafe;
import com.malinovsky.kafedra.service.CafeService;
import com.nixsolutions.commons.service.impl.GenericServiceImpl;

@Service
public class CafeServiceImpl extends GenericServiceImpl<Cafe, Long, CafeDao>
		implements CafeService {
	@Autowired
	protected CafeServiceImpl(CafeDao dao) {
		super(dao);
	}

}
