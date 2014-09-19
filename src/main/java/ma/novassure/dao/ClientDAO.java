package ma.novassure.dao;

import java.util.List;

import ma.novassure.domaine.Client;

/**
 * 
 */
public interface ClientDAO {

    public Client addClient(Client client);

    public void updateClient(Client client);

    public Client findClientById(int id);

    public Client findClientByName(String name);
    
    public List<Client> findAllClients();

}