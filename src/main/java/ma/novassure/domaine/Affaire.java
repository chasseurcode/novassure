package ma.novassure.domaine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author TARAM & BODIE
 */
public class Affaire {

    private int id;
    private Date createdDate;
    private Date updatedDate;
    private Client client;
    private List<Quittance> quittances;
    private List<Paiement> paiements;
    private List<Document> documents;
    
    public Affaire() {
    	this.quittances=new ArrayList<Quittance>();
    	this.paiements=new ArrayList<Paiement>();
    }


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public Date getUpdatedDate() {
		return updatedDate;
	}


	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}


	public List<Quittance> getQuittances() {
		return quittances;
	}

	public void setQuittances(List<Quittance> quittances) {
		this.quittances = quittances;
	}
	
	public void addQuittance(Quittance quittance) {
		quittances.add(quittance);
	}
	
	public void removeQuitance(Quittance quittance) {
		this.quittances.remove(quittance);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}


	public void addPaiement(Paiement paiement) {
		paiements.add(paiement);
	}
	
	public void removeQuitance(Paiement paiement) {
		this.paiements.remove(paiement);
	}
	
	public void addDocument(Document document) {
		documents.add(document);
	}
	
	public void removeDocument(Document document) {
		documents.remove(document);
	}


	public List<Document> getDocuments() {
		return documents;
	}


	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	
}