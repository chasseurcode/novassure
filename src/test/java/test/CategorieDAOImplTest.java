package test;

import static org.junit.Assert.assertNotNull;
import ma.novassure.daoimpl.CategorieDAOImpl;
import ma.novassure.domaine.Categorie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategorieDAOImplTest {
   CategorieDAOImpl impl;
   Categorie c1,c2,testCat;
   
	@Before
	public void setUp() throws Exception {
		impl=new CategorieDAOImpl();
		impl.addCategorie(new Categorie("cat1", "10"));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCategorie() {
		testCat=null;
		testCat=impl.addCategorie(new Categorie("cat2","12"));
		assertNotNull("L'id de la nouvelle categorie ne doit pas etre null", testCat.getId());
	}

	@Test
	public void testUpdateCategorie() {
		testCat=null;
		testCat=impl.findCategorieById(1);
		testCat.setCode("40");
		impl.updateCategorie(testCat);
		testCat=null;
		testCat=impl.findCategorieById(1);
		assertEquals("Le code de la nouvelle categorie doit etre 40", "40", testCat.getCode());
	}

	@Test
	public void testFindCategorieById() {
		testCat=null;
		testCat=impl.findCategorieById(1);
		assertEquals("le libellé de la categorie doit etre egale à cat1", "cat1", testCat.getLibelle());
	}

	@Test
	public void testFindCategorieByName() {
		testCat=null;
		impl.addCategorie(new Categorie("cat3","13"));
		testCat=impl.findCategorieByName("cat3");
		assertEquals("Le code de la categorie doit etre 13", "13", testCat.getCode());
	}

	@Test
	public void testFindCategorieByCode() {
		testCat=null;
		impl.addCategorie(new Categorie("cat4", "16"));
		testCat=impl.findCategorieByCode("16");
		assertEquals("le libellé de la categorie doit etre cat4", "cat4", testCat.getLibelle());
	}

}
