package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import ma.novassure.daoimpl.AgentDAOImpl;
import ma.novassure.domaine.Agent;
import ma.novassure.utils.HibernateUtil;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AgentDAOImplTest {
	SessionFactory sessionFactory;
	AgentDAOImpl impl;
	Agent a1;
	Agent a2;
	Agent testAgent;
	@Before
	public void setUp() throws Exception {
		impl=new AgentDAOImpl(HibernateUtil.getSession());	
		a1=new Agent("001", "ali", "sanogo", "assabah", "ali@gmail.com", "0656282175");
		a2=new Agent("002", "Mohamed", "Benali", "ocean", "benali@gmail.com", "0246282376");
		impl.addAgent(a2);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAgent() {
		testAgent=impl.addAgent(a1);
		assertNotNull("L'id du nouveau agent doit etre different de null",testAgent.getId());
	}

	@Test
	public void testUpdateAgent() {
		testAgent=impl.findAgentById(1);
		assertNotNull("L'id de l'agent retourné ne doit pas etre null", testAgent.getId());
		
		testAgent.setCode("A002");
		impl.updateAgent(testAgent);
		Agent newAgent =impl.findAgentById(1);
		assertEquals("le code de l'agent retourné doit corespondre au changement", "A002",newAgent.getCode());
	}

	@Test
	public void testFindAgentById() {
		testAgent=impl.findAgentById(1);
		assertEquals("Le nom de l'agent doit etre Mohamed", "Mohamed", testAgent.getNom());
	}

	@Test
	public void testFindAgentByCode() {
		
		testAgent=impl.findAgentByCode("002");
		assertEquals("le prenom de l'agent retourne doit etre Benali", "Benali",testAgent.getPrenom());
	}
}
