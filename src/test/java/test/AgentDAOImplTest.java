package test;

import static org.junit.Assert.*;
import ma.novassure.daoimpl.AgentDAOImpl;
import ma.novassure.domaine.Agent;

import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AgentDAOImplTest {
	SessionFactory sessionFactory;
	AgentDAOImpl impl;

	@Before
	public void setUp() throws Exception {
		impl=new AgentDAOImpl();		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAgent() {
		Agent agent =new Agent();
		agent.setAdresse("rabat");
		agent.setCode("1b");
		agent.setEmail("mail");
		agent.setNom("toto");
		agent.setPrenom("prenom");
		agent.setTelephone("telephone");
		impl.addAgent(agent);
		assertNotNull(agent);
		assertEquals("toto", agent.getNom());
	}

	@Test
	public void testUpdateAgent() {
		Agent agent= impl.findAgentById(1);
		agent.setNom("maj");
		agent.setPrenom("lili");
		agent.setTelephone("tel");
		impl.updateAgent(agent);
		assertNotNull(agent);
		assertEquals("1a", agent.getCode());
		assertEquals("maj", agent.getNom());	

	}

	@Test
	public void testFindAgentById() {
		Agent agent= impl.findAgentById(1);
		assertNotNull(agent);
		assertEquals("1a", agent.getCode());		
	}

	@Test
	public void testFindAgentByCode() {
		Agent agent= impl.findAgentByCode("1a");
		assertNotNull(agent);
		assertEquals("totyhhho", agent.getNom());	
	}

	@Test
	public void testFindAgentByName() {
		Agent agent= impl.findAgentByName("totyhhho");
		assertNotNull(agent);
		assertEquals("totyhhho", agent.getNom());	
	}

}
