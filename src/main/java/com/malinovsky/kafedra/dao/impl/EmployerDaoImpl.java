package com.malinovsky.kafedra.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.malinovsky.kafedra.dao.EmployerDao;
import com.malinovsky.kafedra.exception.DaoException;
import com.malinovsky.kafedra.model.Employer;
import com.nixsolutions.commons.db.dao.impl.GenericDaoHibernate;

@Repository
public class EmployerDaoImpl extends GenericDaoHibernate<Employer, Long>
		implements EmployerDao {
	private static final Logger LOG = LoggerFactory
			.getLogger(EmployerDaoImpl.class);

	@Override
	public Employer findByEmail(String email) {
		try {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(Employer.class);
			criteria.add(Restrictions.eq("email", email));
			return (Employer) findUniqueByCriteria(criteria, false);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new DaoException(e);
		}
	}

	@Override
	public List<Employer> findByCafeId(Long id) {
		try {
			DetachedCriteria criteria = DetachedCriteria
					.forClass(Employer.class);
			criteria.add(Restrictions.eq("cafe.id", id));
			return findByCriteria(criteria, false);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw new DaoException(e);
		}
	}

}
