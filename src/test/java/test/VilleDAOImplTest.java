package test;

import static org.junit.Assert.*;
import ma.novassure.daoimpl.VilleDAOImpl;
import ma.novassure.domaine.Ville;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VilleDAOImplTest {
	SessionFactory sessionFactory;
	VilleDAOImpl impl;

	@Before
	public void setUp() throws Exception {
		impl=new VilleDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddVille() {
		Ville ville=new Ville();
		ville.setCode("123");
		ville.setNom("kenitra");
		impl.addVille(ville);
		assertNotNull(ville);
		assertEquals("kenitra", ville.getNom());
	}

	@Test
	public void testUpdateVille() {
		Ville ville=impl.findVilleById(1);
		ville.setNom("oujdaa");
		impl.updateVille(ville);
		assertNotNull(ville);
		assertEquals("oujdaa", ville.getNom());

	}

	@Test
	public void testFindVilleById() {
		Ville ville=impl.findVilleById(2);
		assertNotNull(ville);
		assertEquals("kenitra", ville.getNom());
	}

	@Test
	public void testFindVilleByName() {
		Ville ville=impl.findVilleByName("oujdaa");
		assertNotNull(ville);
		assertEquals("oujdaa", ville.getNom());
	}

}
