package ma.novassure.dao;

import java.util.List;

import ma.novassure.domaine.Client;
import ma.novassure.domaine.Entreprise;
import ma.novassure.domaine.Particulier;

/**
 * 
 */
public interface ClientDAO {

    public Client addClient(Client client);

    public void updateClient(Client client);

    public Client findClientById(int id);

    public Client findClientByName(String name);
    
    public List<Client> findAllClients();
    
    public List<Entreprise> findAllEntreprises();
    
    public List<Particulier> findAllParticuliers();
    
    public Particulier findClientByCin(String cin);

	public Entreprise findClientByNrc(String nrc);

}