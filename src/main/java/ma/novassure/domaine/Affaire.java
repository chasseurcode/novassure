package ma.novassure.domaine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * @author TARAM & BODIE
 */
@Entity
public class Affaire {

	@Id @GeneratedValue
	private int id;

	private Date createdDate;
	private Date updatedDate;
	private int step;
	private boolean validete=false;
	private User user;
	@ManyToOne
	private Client client;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Quittance> quittances;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Paiement> paiements;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Document> documents;

	public Affaire() {
		this.createdDate=new Date();
		this.updatedDate=new Date();
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
		quittance.setAffaire(this);
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


	public int getStep() {
		return step;
	}


	public void setStep(int step) {
		this.step = step;
	}


	public boolean isValidete() {
		return validete;
	}


	public void setValidete(boolean validete) {
		this.validete = validete;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



}
