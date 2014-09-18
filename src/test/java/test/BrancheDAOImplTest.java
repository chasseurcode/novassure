package test;

import ma.novassure.daoimpl.BrancheDAOImpl;
import ma.novassure.domaine.Branche;
import ma.novassure.utils.HibernateUtil;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*; 

public class BrancheDAOImplTest {
	BrancheDAOImpl impl;
	Branche b1,b2,testBranche;
	

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
		testBranche=impl.findBrancheById(1);
		assertNotNull("la branche retourné ne doit pas etre null",testBranche);
		testBranche.setLibelle("newLibelle");
		impl.updateBranche(testBranche);
		Branche updateBranche=impl.findBrancheById(1);
		assertEquals("Le nouveau libelle doit etre egale à newlibelle", "newLibelle",updateBranche.getLibelle());
	}

	@Test
	public void testFindBrancheById() {
		testBranche=null;
		testBranche=impl.findBrancheById(1);
		assertNotNull("La branche retourné ne doit pas etre null", testBranche);
	}
	
	@Test
	public void testgetAllBranches() {
		int fisrtNumber=impl.findAllBranches().size();
		int total=fisrtNumber+2;
		impl.addBranche(b1);
		impl.addBranche(b2);
		int newNumber=impl.findAllBranches().size();
		
		assertEquals("Le nombre d'enregistrement retourné doit etre "+total, total, newNumber);
	}

}
