package com.malinovsky.kafedra.dao.impl;

import org.springframework.stereotype.Repository;

import com.malinovsky.kafedra.dao.CafeDao;
import com.malinovsky.kafedra.model.Cafe;
import com.nixsolutions.commons.db.dao.impl.GenericDaoHibernate;

@Repository
public class CafeDaoImpl extends GenericDaoHibernate<Cafe, Long> implements
		CafeDao {

}
