package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import ma.novassure.daoimpl.BrancheDAOImpl;
import ma.novassure.domaine.Branche;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BrancheDAOImplTest {
	SessionFactory sessionFactory;
	BrancheDAOImpl impl;

	@Before
	public void setUp() throws Exception {
		impl=new BrancheDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddBranche() {
		Branche branche=new Branche();
		branche.setLibelle("libelle2");
		impl.addBranche(branche);
		assertNotNull(branche);
		assertEquals("libelle2", branche.getLibelle());
	}

	@Test
	public void testUpdateBranche() {
		Branche branche=impl.findBrancheById(1);
		branche.setLibelle("libeller maj");
		assertNotNull(branche);
		assertEquals("libeller maj", branche.getLibelle());
	}

	@Test
	public void testFindBrancheById() {
		Branche branche=impl.findBrancheById(1);
		assertNotNull(branche);
		assertEquals(1, branche.getId());
		
	}

}
