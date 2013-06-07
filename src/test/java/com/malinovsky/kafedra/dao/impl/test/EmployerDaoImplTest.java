package com.malinovsky.kafedra.dao.impl.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.malinovsky.kafedra.exception.DaoException;
import com.malinovsky.kafedra.model.Cafe;
import com.malinovsky.kafedra.model.Employer;
import com.malinovsky.kafedra.model.Role;
import com.malinovsky.kafedra.service.EmployerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testContext.xml")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class EmployerDaoImplTest {
	@Autowired
	private EmployerService ed;

	@Test
	public void testGetAll() throws DaoException {
		assertEquals(45, ed.getAll().size());
	}

	@Test
	public void testFindByEmail() throws DaoException {
		Employer e = ed.findByEmail("malinovskiy-alex@ukr.net");
		assertEquals("Malinovskiy Alex", e.getFIO());
	}

	@Test
	public void testFindByCafeId() throws DaoException {
		List<Employer> list = ed.findByCafeId(3l);
		assertEquals(11, list.size());
	}

	@Test
	public void testDelete() throws DaoException {
		Employer e = ed.findByEmail("bakulin-ivan@ukr.net");
		// assertEquals(10, e.getCafe().getProducts().size());
		assertEquals(45, ed.getAll().size());
		ed.delete(e);
		assertEquals(44, ed.getAll().size());

	}

	@Test
	public void testSave() throws DaoException {
		ed.saveOrUpdate(getTestEmployer());
		assertEquals(46, ed.getAll().size());
	}

	private Employer getTestEmployer() {
		Employer e = new Employer();
		e.setAddress("Ribinskaya 12");
		e.setBirthday(new Date());
		e.setEmail("asdde@ukr.net");
		e.setFIO("ADads sda asd");
		e.setINN(123312123);
		e.setPhone("0993212343");
		e.setMedCoef(12.21);
		Role r = new Role();
		r.setId(2);
		e.setRole(r);
		Cafe c = new Cafe();
		c.setId(3);
		e.setCafe(c);
		return e;
	}
}
