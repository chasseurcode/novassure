package test;

import static org.junit.Assert.*;
import ma.novassure.dao.VilleDAO;
import ma.novassure.daoimpl.VilleDAOImpl;
import ma.novassure.domaine.Ville;
import ma.novassure.utils.HibernateUtil;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class VilleDAOImplTest {
	VilleDAO villeDao;
	Ville v1,v2,villeTest;
	@Before
	public void setUp() throws Exception {
		villeDao=new VilleDAOImpl(HibernateUtil.getSession());
		v1=new Ville("Rabat");
		villeDao.addVille(v1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddVille() {
		v2=villeDao.addVille(new Ville("Casa"));
		assertNotNull("L'id de la nouvelle ville doit etre differnt de null", v2);
	}

	@Test
	public void testUpdateVille() {
		villeTest=null;
		villeTest=villeDao.findVilleById(1);
		assertNotNull("La ville retourné doit etre différent de null", villeTest);
		
		villeTest.setNom("Marrakech");
		villeDao.updateVille(villeTest);
		villeTest=null;
		villeTest=villeDao.findVilleById(1);
		assertNotNull("La ville retourné doit etre différent de null", villeTest);
		assertEquals("Le nom de la ville doit etre Marrakech", "Marrakech", villeTest.getNom());
	}

	@Test
	public void testFindVilleById() {
	villeTest=null;
	villeTest=villeDao.findVilleById(1);
	assertNotNull("La ville doit etre different de null", villeTest);
	assertEquals("Le nom de la ville doit Rabat", "Rabat", villeTest.getNom());
	}

	@Test
	public void testFindVilleByName() {
		villeDao.addVille(new Ville("Settat"));
		villeTest=null;
		villeTest=villeDao.findVilleByName("Settat");
		assertNotNull("La ville doit etre different de null", villeTest);
		assertEquals("Le nom de la ville doit Settat", "Settat", villeTest.getNom());
	}

}
