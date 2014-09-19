package ma.novassure.daoimpl;

import java.util.List;

import org.hibernate.Session;

import ma.novassure.dao.ClientDAO;
import ma.novassure.domaine.Client;
import ma.novassure.domaine.Entreprise;
import ma.novassure.domaine.Particulier;

/**
 * @author TARAM & BODIE
 */
public class ClientDAOImpl implements ClientDAO {
   Session session;
   
    public ClientDAOImpl(Session session) {
    	this.session=session;
    }

	public void updateClient(Client client) {
		session.beginTransaction();
		session.update(client);
		session.flush();
		session.getTransaction().commit();
	}

	public Client findClientById(int id) {
		return (Client) session.get(Client.class, id);
	}

	public Client findClientByName(String name) {
		
		return (Client) session.createQuery("From Client where nom= :nom")
									.setString("nom", name)
									.uniqueResult();
	}

	public Client addClient(Client client) {
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit();
		return client;
	}

	@SuppressWarnings("unchecked")
	public List<Client> findAllClients() {
		return session.createQuery("From Client").list();
	}

	@SuppressWarnings("unchecked")
	public List<Entreprise> findAllEntreprises() {
		return session.createQuery("From Entreprise").list();
	}

	@SuppressWarnings("unchecked")
	public List<Particulier> findAllParticuliers() {
		return session.createQuery("From Particulier").list();
	}

}