package test;

import java.util.List;

import ma.novassure.dao.TypeQuittanceDAO;
import ma.novassure.daoimpl.TypeQuittanceDAOImpl;
import ma.novassure.domaine.TypeQuittance;
import ma.novassure.utils.HibernateUtil;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TypeQuittanceTest {
	TypeQuittanceDAO dao;
	TypeQuittance q1,q2,testQuit;
	@Before
	public void setUp() {
		dao=new TypeQuittanceDAOImpl(HibernateUtil.getSession());
		q1=new TypeQuittance("LOP");
		dao.addTypeQuittance(q1);
	}
	
	@Test
	public void testAddTypeQuittance() {
		q2=new TypeQuittance("SOLDE");
		testQuit=null;
		testQuit=dao.addTypeQuittance(q2);
		assertNotNull("Le nouveau Type doit etre difféernt de null", testQuit);
		assertNotNull("L'id du nouveau type doit pas etre null",testQuit.getId());
	}

	@Test
	public void testUpdateTypeQuittance() {
		testQuit=null;
		testQuit=dao.findTypeQuittanceById(1);
		assertNotNull("Le type retourné doit etre diffèrent de null", testQuit);
		
		testQuit.setLibelle("DEFF");
		dao.updateTypeQuittance(testQuit);
		
		testQuit=null;
		testQuit=dao.findTypeQuittanceById(1);
		assertNotNull("Le type recuperer doit pas etre null", testQuit);
		assertEquals("Le libbéelé du type doit etre", "DEFF", testQuit.getLibelle());
	}

	@Test
	public void findTypeQuittanceByLibelle() {
		testQuit=null;
		testQuit=dao.findTypeQuittanceByLibelle("LOP");
		assertNotNull("Le type ne doit pas etre null", testQuit);
		assertEquals("Le libbéllé doit etre", "LOP",testQuit.getLibelle());
	}

	@Test
	public void testFindTypeQuittanceById() {
		testQuit=null;
		testQuit=dao.findTypeQuittanceById(1);
		assertNotNull("Le type ne doit pas etre null", testQuit);
	}

	@Test
	public void testFindAllTypes() {
		List<TypeQuittance> typeQuittances=dao.findAllTypes();
		assertNotNull("Le Liste des type ne doit pas etre null", typeQuittances);
		assertNotEquals("La taille de la liste doit depasser 0", 0, typeQuittances.size());
	}
	
}
