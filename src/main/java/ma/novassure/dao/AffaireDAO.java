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


    /**
     * @param affaire
     */
    public void createAffaire(Affaire affaire);
    
    /**
     * @param client
     */
    public void addClient(Client client);

    /**
     * @param affaire
     */
    public void updateAffaire(Affaire affaire);

    /**
     * @param id 
     * @return
     */
    public Affaire findAffaireById(int id);

    /**
     * @param quittance
     */
    public void addQuittance(Quittance quittance);

    /**
     * @param document
     */
    public void addDocument(Document document);

    /**
     * @param paiement
     */
    public void addPaiement(Paiement paiement);

    /**
     * @param quittance
     */
    public void updateQuittance(Quittance quittance);

    /**
     * @param id 
     * @return
     */
    public Quittance findQuittanceById(int id);

    /**
     * @param numero 
     * @return
     */
    public Quittance findQuittanceByNumero(String numero);

    /**
     * @param document
     */
    public void updateDocument(Document document);

    /**
     * @param id 
     * @return
     */
    public Document findDocumentById(int id);

    /**
     * @param paiement
     */
    public void updatePaiement(Paiement paiement);

    /**
     * @param id 
     * @return
     */
    public Paiement findPaiementById(int id);

    /**
     * @param title 
     * @return
     */
    public Document findDocumentByTitle(String title);

}