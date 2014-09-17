package test;

import static org.junit.Assert.*;
import ma.novassure.daoimpl.CategorieDAOImpl;
import ma.novassure.domaine.Categorie;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CategorieDAOImplTest {
	SessionFactory sessionFactory;
   CategorieDAOImpl impl;
   
	@Before
	public void setUp() throws Exception {
		impl=new CategorieDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCategorie() {
		Categorie categorie=new Categorie();
		categorie.setCode(12345);
		categorie.setLibelle("libelle7");
		impl.addCategorie(categorie);
		assertNotNull(categorie);
		assertEquals("libelle7", categorie.getLibelle());
	}

	@Test
	public void testUpdateCategorie() {
		Categorie categorie=impl.findCategorieById(1);
		categorie.setLibelle("lelib");
		impl.updateCategorie(categorie);
		assertNotNull(categorie);
		assertEquals("lelib", categorie.getLibelle());
		
	}

	@Test
	public void testFindCategorieById() {
		Categorie categorie=impl.findCategorieById(1);
		assertNotNull(categorie);
		assertEquals("lelib", categorie.getLibelle());
	}

	@Test
	public void testFindCategorieByName() {
		Categorie categorie=impl.findCategorieByName("libelle3");
		assertNotNull(categorie);
		assertEquals("libelle3", categorie.getLibelle());
	}

	@Test
	public void testFindCategorieByCode() {
		Categorie categorie=impl.findCategorieByCode(123);
		assertNotNull(categorie);
		assertEquals(123, categorie.getCode());
	}

}
