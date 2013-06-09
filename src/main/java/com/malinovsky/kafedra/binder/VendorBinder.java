package com.malinovsky.kafedra.binder;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.malinovsky.kafedra.model.Vendor;
import com.malinovsky.kafedra.service.VendorService;

@Component
public class VendorBinder extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Vendor vendor = null;
		if (!text.isEmpty()) {
			vendor = getVendorService().findById(Long.valueOf(text));
		}
		setValue(vendor);
	}

	private VendorService getVendorService() {
		HttpServletRequest request = (HttpServletRequest) RequestContextHolder
				.getRequestAttributes().resolveReference(
						RequestAttributes.REFERENCE_REQUEST);
		return (VendorService) WebApplicationContextUtils
				.getWebApplicationContext(
						request.getSession().getServletContext()).getBean(
						"vendorServiceImpl");
	}
}
