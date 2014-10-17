package ma.novassure.dao;

import ma.novassure.domaine.Affaire;
import ma.novassure.domaine.Client;
import ma.novassure.domaine.Document;
import ma.novassure.domaine.Paiement;
import ma.novassure.domaine.Quittance;


/**
 * 
 */
public interface AffaireDAO {
	
    public void createAffaire(Affaire affaire);
    
    public void addClient(Client client);

    public void updateAffaire(Affaire affaire);

    public Affaire findAffaireById(int id);

    public void addQuittance(Quittance quittance);

    public void addDocument(Document document);

    public void addPaiement(Paiement paiement);

    public void updateQuittance(Quittance quittance);

    public Quittance findQuittanceById(int id);

    public Quittance findQuittanceByNumPolice(String numero);

    public void updateDocument(Document document);

    public Document findDocumentById(int id);

    public void updatePaiement(Paiement paiement);

    public Paiement findPaiementById(int id);

    public Document findDocumentByTitle(String title);

}