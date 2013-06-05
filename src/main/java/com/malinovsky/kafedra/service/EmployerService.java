package com.malinovsky.kafedra.service;

import java.util.List;

import com.malinovsky.kafedra.dao.EmployerDao;
import com.malinovsky.kafedra.model.Employer;
import com.nixsolutions.commons.service.GenericService;

public interface EmployerService extends
		GenericService<Employer, Long, EmployerDao> {
	Employer findByEmail(String email);

	List<Employer> findByCafeId(Long id);

	Employer getAuthenticatedEmployer();
}
