package com.malinovsky.kafedra.dao.impl;

import org.springframework.stereotype.Repository;

import com.malinovsky.kafedra.dao.CafeProductDao;
import com.malinovsky.kafedra.model.CafeProduct;
import com.nixsolutions.commons.db.dao.impl.GenericDaoHibernate;

@Repository
public class CafeProductDaoImpl extends GenericDaoHibernate<CafeProduct, Long>
		implements CafeProductDao {

}
