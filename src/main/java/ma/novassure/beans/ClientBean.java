package ma.novassure.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import ma.novassure.dao.ClientDAO;
import ma.novassure.daoimpl.ClientDAOImpl;
import ma.novassure.domaine.Entreprise;
import ma.novassure.domaine.Particulier;
import ma.novassure.domaine.Ville;
import ma.novassure.utils.HibernateUtil;

@ManagedBean
@RequestScoped
public class ClientBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientDAO clientDAO;
	private Entreprise entreprise;
	private Particulier particulier;
	private String typeClient;
	private String email;
	private String telephone;
	private String adresse;
	private String nom;
	private String faxe;
	private Ville laVille;
	private String ClientId;
	
	public ClientBean() {
		clientDAO=new ClientDAOImpl(HibernateUtil.getSession());
		particulier=new Particulier();
		entreprise=new Entreprise();
	}
	
	
	


	public ClientDAO getClientDAO() {
		return clientDAO;
	}


	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}


	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}


	public Particulier getParticulier() {
		return particulier;
	}


	public void setParticulier(Particulier particulier) {
		this.particulier = particulier;
	}


	public String getTypeClient() {
		return typeClient;
	}


	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getFaxe() {
		return faxe;
	}


	public void setFaxe(String faxe) {
		this.faxe = faxe;
	}


	public Ville getLaVille() {
		return laVille;
	}


	public void setLaVille(Ville laVille) {
		this.laVille = laVille;
	}


	public String getClientId() {
		return ClientId;
	}


	public void setClientId(String clientId) {
		ClientId = clientId;
	}
	
	
	
	

}
