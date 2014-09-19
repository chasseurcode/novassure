package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import ma.novassure.dao.CompagnieDAO;
import ma.novassure.daoimpl.CompagnieDAOImpl;
import ma.novassure.domaine.Compagnie;
import ma.novassure.utils.HibernateUtil;

import org.junit.Before;
import org.junit.Test;
public class CompagnieDaoTest{
	CompagnieDAO compDao;
	Compagnie c1,c2,testComp;
	
	@Before
	public void setUp() {
		compDao=new CompagnieDAOImpl(HibernateUtil.getSession());	
		c1=new Compagnie("001", "0928826633", "Boulevard", null, "0928826633", "AXA Assurance", null);
		compDao.addCompagnie(c1);
	}

	@Test
	public void testAddCompagnie() {
		c2=new Compagnie("002", "0928826633", "Solprime", null, "0928826633", "Novassure", null);
		testComp=null;
		testComp=compDao.addCompagnie(c2);
		assertNotNull("La compagnie retourné ne doit pas etre null",testComp);
		assertNotNull("L'id de la nouvelle compagnie doit etre different de null",testComp.getId());
	}
	
	@Test
	public void testUpdateCompagnie() {
		testComp=null;
		testComp=compDao.findCompagnieById(1);
		assertNotNull("La compagnagnie retourné ne doit pas etre null", testComp);
		testComp.setAdresse("Residenece Asso");
		compDao.updateCompagnie(testComp);
		Compagnie c3=compDao.findCompagnieById(1);
		assertEquals("L'adresse de la compagnie doit etre Residenece Asso", "Residenece Asso",c3.getAdresse());
	}

	@Test
	public void testFindCompagnieById() {
		testComp=null;
		testComp=compDao.findCompagnieById(1);
		assertNotNull("la compagnie ne doit pas etre null", testComp);
		assertEquals("Le nom de la compagnie doit etre AXA Assurance", "AXA Assurance", testComp.getNom());
	}

	@Test
	public void testFindCompagnieByName() {
		testComp=null;
		testComp=compDao.findCompagnieByName("AXA Assurance");
		assertNotNull("la compagnie ne doit pas etre null", testComp);
		assertEquals("Le code de la compagnie retournée doit etre 001", "001", testComp.getCode());
	}
	
	@Test
	public void testFindAllCompgnies() {
		testComp=null;
		List<Compagnie> compagnies=compDao.findAllCompagnies();
		assertNotNull("la liste ne doit pas etre null", compagnies);
		assertNotEquals("La taille de la liste retourner doit etre different de 0", 0, compagnies.size());
	}
}
