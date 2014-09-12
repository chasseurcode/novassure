package ma.novassure.dao;

import ma.novassure.domaine.Client;

/**
 * 
 */
public interface ClientDAO {


    /**
     * @param client
     */
    public void addClient(Client client);

    /**
     * @param client
     */
    public void updateClient(Client client);

    /**
     * @param id 
     * @return
     */
    public Client findClientById(int id);

    /**
     * @param name 
     * @return
     */
    public Client findClientByName(String name);

}