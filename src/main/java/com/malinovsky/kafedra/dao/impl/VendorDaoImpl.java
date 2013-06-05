package com.malinovsky.kafedra.dao.impl;

import org.springframework.stereotype.Repository;

import com.malinovsky.kafedra.dao.VendorDao;
import com.malinovsky.kafedra.model.Vendor;
import com.nixsolutions.commons.db.dao.impl.GenericDaoHibernate;

@Repository
public class VendorDaoImpl extends GenericDaoHibernate<Vendor, Long> implements
		VendorDao {

}
