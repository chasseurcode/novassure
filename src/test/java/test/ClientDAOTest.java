package test;

import static org.junit.Assert.*;

import java.util.List;

import ma.novassure.dao.ClientDAO;
import ma.novassure.daoimpl.ClientDAOImpl;
import ma.novassure.domaine.Client;
import ma.novassure.domaine.Entreprise;
import ma.novassure.domaine.Particulier;
import ma.novassure.utils.HibernateUtil;

import org.junit.Before;
import org.junit.Test;

public class ClientDAOTest {
	ClientDAO clientDao;
	Client testClient;
	Particulier part1,part2;
	Entreprise entrep1,entrep2;
	@Before
	public void setUp() throws Exception {
		clientDao=new ClientDAOImpl(HibernateUtil.getSession());
		entrep2=new Entreprise();
		entrep2.setNom("BoniSoft");
		entrep2.setTelephone("002992333");
		
		part1=new Particulier();
		part1.setNom("Sanogo");
		part1.setPrenom("Sori");
		
		clientDao.addClient(entrep2);
		clientDao.addClient(part1);
	}
	
	@Test
	public void testAddClient() {
		entrep1=new Entreprise();
		entrep1.setNom("AXA");
		entrep1.setNrc("10RC");
		testClient=clientDao.addClient(entrep1);
		assertNotNull("Le client retourné ne doit pas etre null", testClient);
		assertNotNull("L'id du cilent ne noi pas etre null", testClient.getId());
		
		part2=new Particulier();
		part2.setNom("Sali");
		part2.setPrenom("Traore");
		testClient=null;
		testClient=clientDao.addClient(part2);
		assertNotNull("L'id du cilent ne noi pas etre null", testClient.getId());
		
	}

	@Test
	public void testUpdateClient() {
		testClient=null;
		testClient=clientDao.findClientById(1);
		assertNotNull("Le client retourné ne doit pas etre null", testClient);
		
		testClient.setAdresse("Rue 01");
		clientDao.updateClient(testClient);
		
		testClient=null;
		testClient=clientDao.findClientById(1);
		assertNotNull("Le client retourné ne doit pas etre null", testClient);
		assertEquals("L'adresse du client retourné doit etre Rue 01", "Rue 01", testClient.getAdresse());
		
	}

	@Test
	public void testFindClientById() {
		testClient=clientDao.findClientById(1);
		assertNotNull("Le client retourné ne doit pas etre null", testClient);
		assertNotNull("L'Id client retourné ne doit pas etre null", testClient.getId());
	}

	@Test
	public void testFindClientByName() {
		Entreprise e1=(Entreprise) clientDao.findClientByName("BoniSoft");
		assertNotNull("Le client retourné ne doit pas etre null", e1);
		assertEquals("Le nom du client doit etre ", "002992333", e1.getTelephone());
	}

	@Test
	public void testFindAllClients() {
		List<Client> clients=clientDao.findAllClients();
		assertNotNull("La liste de client ne doit pas etre null", clients);
		assertNotEquals("La taille de la liste des client doit etre different de 0", 0, clients.size());
	}
	
	public void testFindAllEntreprises() {
		List<Entreprise> entreprises=clientDao.findAllEntreprises();
		assertNotNull("La liste d'entreprise ne doit pas ere null", entreprises);
		assertNotEquals("La taille de la liste doit etre superieur a 0",0, entreprises.size());
	}
	
	public void testFindAllParticuliers() {
		List<Particulier> particuliers=clientDao.findAllParticuliers();
		assertNotNull("La liste d'entreprise ne doit pas ere null", particuliers);
		assertNotEquals("La taille de la liste doit etre superieur a 0",0, particuliers.size());
	}

}
