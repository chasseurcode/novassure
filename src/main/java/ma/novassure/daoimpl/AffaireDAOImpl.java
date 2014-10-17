package ma.novassure.daoimpl;

import ma.novassure.dao.AffaireDAO;
import ma.novassure.domaine.Affaire;
import ma.novassure.domaine.Client;
import ma.novassure.domaine.Document;
import ma.novassure.domaine.Paiement;
import ma.novassure.domaine.Quittance;

import org.hibernate.Session;

/**
 * @author TARAM & BODIE
 */
public class AffaireDAOImpl implements AffaireDAO {

	private Session session;

	   
    public AffaireDAOImpl(Session session) {
		this.session=session;
    }

	public void createAffaire(Affaire affaire) {
		session.beginTransaction();
		session.save(affaire);
		session.getTransaction().commit(); 
	}

	public void addClient(Client client) {
		session.beginTransaction();
		session.save(client);
		session.getTransaction().commit(); 
	}

	public void updateAffaire(Affaire affaire) {
		session.beginTransaction();
		session.update(affaire);
		session.getTransaction().commit();			
	}

	public Affaire findAffaireById(int id) {
		return (Affaire) session.get(Affaire.class, id);
	}

	public void addQuittance(Quittance quittance) {
		session.beginTransaction();
		session.save(quittance);
		session.getTransaction().commit(); 
	}

	public void addDocument(Document document) {
		session.beginTransaction();
		session.save(document);
		session.getTransaction().commit(); 		
	}

	public void addPaiement(Paiement paiement) {
		session.beginTransaction();
		session.save(paiement);
		session.getTransaction().commit(); 		
	}

	public void updateQuittance(Quittance quittance) {
		session.beginTransaction();
		session.update(quittance);
		session.getTransaction().commit();
	}

	public Quittance findQuittanceById(int id) {
		return (Quittance) session.get(Quittance.class, id);

	}

	public Quittance findQuittanceByNumPolice(String numero) {
		Quittance quittance=(Quittance) session.createQuery("from Quittance where numPolice= :numero")
				.setString("numero", numero).uniqueResult();
		return quittance;
	}

	public void updateDocument(Document document) {
		session.beginTransaction();
		session.update(document);
		session.getTransaction().commit();		
	}

	public Document findDocumentById(int id) {
		return (Document) session.get(Document.class, id);
	}

	public void updatePaiement(Paiement paiement) {
		session.beginTransaction();
		session.update(paiement);
		session.getTransaction().commit();		
	}

	public Paiement findPaiementById(int id) {
		return (Paiement) session.get(Paiement.class, id);
	}
	public Document findDocumentByTitle(String title) {
		Document document=(Document) session.createQuery("from Document where titre= :title")
				.setString("title", title).uniqueResult();
		return document;
	}

}