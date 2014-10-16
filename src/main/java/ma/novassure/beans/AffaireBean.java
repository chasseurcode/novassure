package ma.novassure.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import ma.novassure.dao.AffaireDAO;
import ma.novassure.dao.ClientDAO;
import ma.novassure.dao.VilleDAO;
import ma.novassure.daoimpl.AffaireDAOImpl;
import ma.novassure.daoimpl.ClientDAOImpl;
import ma.novassure.daoimpl.VilleDAOImpl;
import ma.novassure.domaine.Affaire;
import ma.novassure.domaine.Entreprise;
import ma.novassure.domaine.Particulier;
import ma.novassure.domaine.Ville;
import ma.novassure.utils.HibernateUtil;

import org.primefaces.event.FlowEvent;

@ManagedBean
@ViewScoped
public class AffaireBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Logger logger=Logger.getLogger(AffaireBean.class.getName());
	private ClientDAO clientDAO;
	private VilleDAO villeDAO;
	private AffaireDAO affaireDAO;
	private String myCin;
	private String myNrc;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;
	private String nom;
	private String faxe;
	private String maVille;	
	private Ville laVille;
	private String typeClient;
	private Particulier particulier;
	private Entreprise entreprise;
	private Affaire affaire;
	private List<Particulier> particuliers;
	private List<Entreprise> entreprises;
	private List<Ville> villes;



	public AffaireBean() {
		clientDAO=new ClientDAOImpl(HibernateUtil.getSession());
		villeDAO= new VilleDAOImpl(HibernateUtil.getSession());
		affaireDAO=new AffaireDAOImpl(HibernateUtil.getSession());
		particulier=new Particulier();
		entreprise=new Entreprise();
		particuliers=new ArrayList<Particulier>();
		entreprises=new ArrayList<Entreprise>();
		villes=new ArrayList<Ville>();
		villes=villeDAO.findAllVille();
	}

	public void searchParticulier(ActionEvent event){
		particulier=clientDAO.findClientByCin(myCin);
		particuliers.add(particulier);

	}

	public void searchEntreprise(ActionEvent event){
		entreprise=clientDAO.findClientByNrc(myNrc);
		entreprises.add(entreprise);	
	}

	public void updateClient(ActionEvent event){
		System.out.println("entrer");
		if(particulier!=null){
			clientDAO.updateClient(particulier);
		}
		if(entreprise!=null){
			clientDAO.updateClient(entreprise);
		}
	}
	
	public void clear(){
		particuliers=new ArrayList<Particulier>();
		entreprises=new ArrayList<Entreprise>();
		particulier=new Particulier();
		entreprise=new Entreprise(); 
	}

	public String onFlowProcess(FlowEvent event) {
		System.out.println("affaire creer");
		return event.getNewStep();		
	}

	public void load(Particulier p,Entreprise e){
		if(p!=null){
			setParticulier(p);
			setTypeClient("particulier");
			nom=particulier.getNom();
			prenom=particulier.getPrenom();
			telephone=particulier.getTelephone();
			email=particulier.getEmail();
			adresse=particulier.getAdresse();
		}
		if(e!=null){
			setEntreprise(e);
			setTypeClient("entreprise");
			nom=entreprise.getNom();
			telephone=entreprise.getTelephone();
			email=entreprise.getEmail();
			adresse=entreprise.getAdresse();

		}

	}

	

	//-----------------------getters et setters------------------------
	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	public String getMyCin() {
		return myCin;
	}

	public void setMyCin(String myCin) {
		this.myCin = myCin;
	}

	public String getMyNrc() {
		return myNrc;
	}

	public void setMyNrc(String myNrc) {
		this.myNrc = myNrc;
	}

	public Particulier getParticulier() {
		return particulier;
	}

	public void setParticulier(Particulier particulier) {
		this.particulier = particulier;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public List<Particulier> getParticuliers() {
		return particuliers;
	}

	public void setParticuliers(List<Particulier> particuliers) {
		this.particuliers = particuliers;
	}

	public List<Entreprise> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(List<Entreprise> entreprises) {
		this.entreprises = entreprises;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public String getMaVille() {
		return maVille;
	}

	public void setMaVille(String maVille) {
		this.maVille = maVille;
	}

	public String getFaxe() {
		return faxe;
	}

	public void setFaxe(String faxe) {
		this.faxe = faxe;
	}

	public String getTypeClient() {
		return typeClient;
	}
	
	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public VilleDAO getVilleDAO() {
		return villeDAO;
	}

	public void setVilleDAO(VilleDAO villeDAO) {
		this.villeDAO = villeDAO;
	}

	public Ville getLaVille() {
		return laVille;
	}

	public void setLaVille(Ville laVille) {
		this.laVille = laVille;
	}

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	public AffaireDAO getAffaireDAO() {
		return affaireDAO;
	}
	
	public void setAffaireDAO(AffaireDAO affaireDAO) {
		this.affaireDAO = affaireDAO;
	}

	public Affaire getAffaire() {
		return affaire;
	}
	
	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}

}
