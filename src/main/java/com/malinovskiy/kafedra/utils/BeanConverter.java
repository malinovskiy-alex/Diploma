package com.malinovskiy.kafedra.utils;

import java.util.ArrayList;
import java.util.List;

import com.malinovsky.kafedra.model.CafeProduct;
import com.malinovsky.kafedra.model.form.WarekeeperBean;

public class BeanConverter {
	public static WarekeeperBean convertToWarekeeperBean(CafeProduct cp) {
		WarekeeperBean result = new WarekeeperBean();
		result.setCafeProductId(cp.getId());
		result.setName(cp.getProduct().getName());
		result.setType(cp.getProduct().getType());
		result.setPrice(cp.getProduct().getPrice());
		result.setAvailable(cp.getAvailableQuantity());
		return result;
	}

	public static List<WarekeeperBean> convertToWarekeeperBeanList(
			List<CafeProduct> list) {
		List<WarekeeperBean> result = new ArrayList<WarekeeperBean>();
		for (CafeProduct cp : list) {
			result.add(convertToWarekeeperBean(cp));
		}
		return result;
	}
}
