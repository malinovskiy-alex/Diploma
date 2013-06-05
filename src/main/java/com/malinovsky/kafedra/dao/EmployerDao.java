package com.malinovsky.kafedra.dao;

import java.util.List;

import com.malinovsky.kafedra.model.Employer;
import com.nixsolutions.commons.db.dao.GenericDao;

public interface EmployerDao extends GenericDao<Employer, Long> {

	Employer findByEmail(String email);

	List<Employer> findByCafeId(Long id);

}
