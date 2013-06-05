package com.malinovsky.kafedra.security;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.service.EmployerService;

public class IdentityUserDetailService implements UserDetailsService {

	private static final Logger LOG = LoggerFactory
			.getLogger(IdentityUserDetailService.class);

	@SuppressWarnings("deprecation")
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException, DataAccessException {
		Employer employer = getEmployerService().findByEmail(email);
		LOG.debug("Load by user name works! Employer is " + employer);
		if (employer != null) {
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			authorities.add(new GrantedAuthorityImpl(employer.getRole()
					.getName()));
			UserDetails userDetails = new User(email, employer.getPassword(),
					true, true, true, true, authorities);
			return userDetails;
		}
		return null;
	}

	private EmployerService getEmployerService() {
		HttpServletRequest request = (HttpServletRequest) RequestContextHolder
				.getRequestAttributes().resolveReference(
						RequestAttributes.REFERENCE_REQUEST);
		return (EmployerService) WebApplicationContextUtils
				.getWebApplicationContext(
						request.getSession().getServletContext()).getBean(
						"employerServiceImpl");
	}
}
