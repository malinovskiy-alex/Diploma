package com.malinovsky.kafedra.dao.impl;

import org.springframework.stereotype.Repository;

import com.malinovsky.kafedra.dao.ProductDao;
import com.malinovsky.kafedra.model.Product;
import com.nixsolutions.commons.db.dao.impl.GenericDaoHibernate;

@Repository
public class ProductDaoImpl extends GenericDaoHibernate<Product, Long>
		implements ProductDao {

}
