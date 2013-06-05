package com.malinovsky.kafedra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.malinovsky.kafedra.dao.EmployerDao;
import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.service.EmployerService;
import com.nixsolutions.commons.service.impl.GenericServiceImpl;

@Service
public class EmployerServiceImpl extends
		GenericServiceImpl<Employer, Long, EmployerDao> implements
		EmployerService {
	@Autowired
	protected EmployerServiceImpl(EmployerDao dao) {
		super(dao);
	}

	@Override
	public Employer findByEmail(String email) {
		return getDao().findByEmail(email);
	}

	@Override
	public Employer getAuthenticatedEmployer() {
		return dao.findByEmail(SecurityContextHolder.getContext()
				.getAuthentication().getName());

	}

	@Override
	public List<Employer> findByCafeId(Long id) {
		return dao.findByCafeId(id);
	}

}
