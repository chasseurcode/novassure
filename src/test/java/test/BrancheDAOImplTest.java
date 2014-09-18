package test;

import java.util.ArrayList;
import java.util.List;

import ma.novassure.daoimpl.BrancheDAOImpl;
import ma.novassure.domaine.Branche;
import ma.novassure.domaine.Categorie;
import ma.novassure.utils.HibernateUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*; 

public class BrancheDAOImplTest {
	BrancheDAOImpl impl;
	Branche b1,b2,testBranche,b3;
	

	@Before
	public void setUp() throws Exception {
		impl=new BrancheDAOImpl();
		b1=new Branche("libelle1");
		b2=new Branche("libelle2");
		impl.addBranche(b1);
	}

	@After
	public void tearDown() throws Exception {
		HibernateUtil.getSession().close();
	}

	@Test
	public void testAddBranche() {
		testBranche=impl.addBranche(b2);
		assertNotNull("l'id de la nouvelle brance doit etre different de null",testBranche.getId());
	}

	@Test
	public void testUpdateBranche() {
		testBranche=null;
		List<Categorie> categories=new ArrayList<Categorie>();
		categories.add(new Categorie("Solde", "001"));
		categories.add(new Categorie("Primaire", "002"));
		
		testBranche=impl.findBrancheById(1);
		assertNotNull("la branche retourné ne doit pas etre null",testBranche);
		
		testBranche.setLibelle("newLibelle");
		testBranche.setCategories(categories);
		
		impl.updateBranche(testBranche);
		Branche updateBranche=impl.findBrancheById(1);
		assertEquals("Le nouveau libelle doit etre egale à newlibelle", "newLibelle",updateBranche.getLibelle());
		
		List<Categorie> updateCat=null;
		updateCat=updateBranche.getCategories();
		
		assertNotNull("la liste des categorie de la branche ne doit pas etre null", updateCat);
		assertEquals("la taille de la liste des categorie doit etre différent de 2", 2, updateCat.size());
		
	}

	@Test
	public void testFindBrancheById() {
		testBranche=null;
		testBranche=impl.findBrancheById(1);
		assertNotNull("La branche retourné ne doit pas etre null", testBranche);
	}
	
	@Test
	public void testgetAllBranches() {
		impl.addBranche(b1);
		impl.addBranche(b2);
		List<Branche> branches=impl.findAllBranches();
		assertNotNull("La liste des branche ne doit pas etre null", branches);
		assertNotEquals("La taille de la liste doit etre différent de 0", 0, branches.size());
	}

}
