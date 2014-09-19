package ma.novassure.daoimpl;

import java.util.List;

import org.hibernate.Session;

import ma.novassure.dao.ClientDAO;
import ma.novassure.domaine.Client;

/**
 * @author TARAM & BODIE
 */
public class ClientDAOImpl implements ClientDAO {
   Session session;
   
    public ClientDAOImpl(Session session) {
    	this.session=session;
    }

	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	public Client findClientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client findClientByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Client addClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Client> findAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

}