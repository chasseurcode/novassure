package ma.novassure.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.novassure.dao.AffaireDAO;
import ma.novassure.dao.AgentDAO;
import ma.novassure.dao.BrancheDAO;
import ma.novassure.dao.ClientDAO;
import ma.novassure.dao.CompagnieDAO;
import ma.novassure.dao.TypeQuittanceDAO;
import ma.novassure.dao.VilleDAO;
import ma.novassure.daoimpl.AffaireDAOImpl;
import ma.novassure.daoimpl.AgentDAOImpl;
import ma.novassure.daoimpl.BrancheDAOImpl;
import ma.novassure.daoimpl.ClientDAOImpl;
import ma.novassure.daoimpl.CompagnieDAOImpl;
import ma.novassure.daoimpl.TypeQuittanceDAOImpl;
import ma.novassure.daoimpl.VilleDAOImpl;
import ma.novassure.domaine.Affaire;
import ma.novassure.domaine.Agent;
import ma.novassure.domaine.Branche;
import ma.novassure.domaine.Categorie;
import ma.novassure.domaine.Client;
import ma.novassure.domaine.Compagnie;
import ma.novassure.domaine.Entreprise;
import ma.novassure.domaine.Garantie;
import ma.novassure.domaine.LigneGarantie;
import ma.novassure.domaine.Particulier;
import ma.novassure.domaine.Quittance;
import ma.novassure.domaine.TypeQuittance;
import ma.novassure.domaine.Ville;
import ma.novassure.utils.HibernateUtil;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.FlowEvent;

@ManagedBean(name="affaireBean")
@SessionScoped
public class AffaireBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private ClientDAO clientDAO;
	private VilleDAO villeDAO;
	private AffaireDAO affaireDAO;
	private	CompagnieDAO compagnieDAO;
	private BrancheDAO brancheDAO;
	private TypeQuittanceDAO typeQuittanceDAO;
	private AgentDAO agentDAO;
	private String myCin;
	private String myNrc;
	private String prenom;
	private String email;
	private String telephone;
	private String adresse;
	private String nom;
	private String maVille;	
	private String faxe;
	private Ville laVille;
	private String duree;
	private String typeClient;
	private Client currentClient;
	private Particulier particulier;
	private Entreprise entreprise;
	private Affaire affaire;
	private Quittance quittance;
	private String  brancheId;
	private String codeAgent;
	private String compagnie;
	private String typeQui;
	private String categorie;
	private List<Particulier> particuliers;
	private List<Entreprise> entreprises;
	private List<Compagnie> compagnies;
	private List<Ville> villes;
	private List<Branche> branches;
	private List<TypeQuittance> typeQuittances;
	private List<Categorie> categories;
	private List<Garantie> garanties;
	private List<LigneGarantie>ligneGaranties;
	private  LigneGarantie lGarantie;
	private double primeTotale;
	private boolean gratuit;
	private double somme=0;
	//-----------fact-----------
	private String refag,contrat;



	public AffaireBean() {
		clientDAO=new ClientDAOImpl(HibernateUtil.getSession());
		villeDAO= new VilleDAOImpl(HibernateUtil.getSession());
		affaireDAO=new AffaireDAOImpl(HibernateUtil.getSession());
		compagnieDAO= new CompagnieDAOImpl(HibernateUtil.getSession());
		brancheDAO=new BrancheDAOImpl(HibernateUtil.getSession());
		typeQuittanceDAO=new TypeQuittanceDAOImpl(HibernateUtil.getSession());
		agentDAO=new AgentDAOImpl(HibernateUtil.getSession());
		particulier=new Particulier();
		entreprise=new Entreprise();
		affaire=new Affaire();
		quittance=new Quittance();
		ligneGaranties=new ArrayList<LigneGarantie>();
		garanties=new ArrayList<Garantie>();
		branches=new ArrayList<Branche>();
		particuliers=new ArrayList<Particulier>();
		entreprises=new ArrayList<Entreprise>();
		villes=new ArrayList<Ville>();
		compagnies=new ArrayList<Compagnie>();
		categories=new ArrayList<Categorie>();
		typeQuittances=new ArrayList<TypeQuittance>();
		typeQuittances=typeQuittanceDAO.findAllEnabledTypes();
		branches=brancheDAO.findAllBranches();
		villes=villeDAO.findAllVille();
		compagnies=compagnieDAO.findAllCompagnies();
	}


	public void searchParticulier(ActionEvent event){
		particulier=clientDAO.findClientByCin(myCin);
		currentClient=particulier;
		particuliers.add(particulier);

	}

	public void searchEntreprise(ActionEvent event){
		entreprise=clientDAO.findClientByNrc(myNrc);
		currentClient=entreprise;
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

	public void addQuittance(){
		if(compagnie!=null && typeQui!=null && codeAgent!=null && categorie!=null){
			Compagnie comp=compagnieDAO.findCompagnieById(Integer.parseInt(compagnie));
			Agent agent=agentDAO.findAgentByCode(codeAgent);
			TypeQuittance typeQuittance=typeQuittanceDAO.findTypeQuittanceById(Integer.parseInt(typeQui));
			quittance.setAgent(agent);
			quittance.setCompagnie(comp);
			quittance.setTypeQuittance(typeQuittance);
			Categorie maCateg=new Categorie();
			for(Categorie cat:categories){
				if(cat.getId()==Integer.parseInt(categorie)){
					maCateg=cat;				
				}
			}	
			garanties=maCateg.getActivedGaranties();
			for(Garantie gar: garanties){
				lGarantie=new LigneGarantie();
				lGarantie.setGarantie(gar);
				ligneGaranties.add(lGarantie);       	  
			}
		}
	}

	public void saveAndQuit(){
		System.out.println("saving ");
		for(LigneGarantie lg:ligneGaranties){
			System.out.println(lg.getPrimeNette()+"");
			lg.setQuittance(quittance);
			quittance.getGaranties().add(lg); 
		}
		quittance.setAffaire(affaire);
		affaire.getQuittances().add(quittance);
		affaireDAO.createAffaire(affaire);
	}

	public void onCellEdit(CellEditEvent event){
		System.out.println("il entre");
		Object newValue = event.getNewValue();
		String cast;
		cast=String.valueOf(newValue);
		System.out.println(cast);
		somme+=Double.parseDouble(cast);		
		setPrimeTotale(somme);
	}


	public void annuller(){
		particulier=new Particulier();
		entreprise=new Entreprise();
		affaire=new Affaire();
		quittance=new Quittance();
		ligneGaranties=new ArrayList<LigneGarantie>();
		garanties=new ArrayList<Garantie>();
		branches=new ArrayList<Branche>();
		particuliers=new ArrayList<Particulier>();
		entreprises=new ArrayList<Entreprise>();
		villes=new ArrayList<Ville>();
		compagnies=new ArrayList<Compagnie>();
		categories=new ArrayList<Categorie>();
		typeQuittances=new ArrayList<TypeQuittance>();
	}

	public String onFlowProcess(FlowEvent event) {
		affichage();
		affaire.setClient(currentClient);
		affaire.setStep(1);
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


	public void loadCategories(){	
		if(brancheId!=null){		
			Branche branche =brancheDAO.findBrancheById(Integer.parseInt(brancheId));
			categories=branche.getCategories();
			System.out.println(branche.getLibelle() + categories.size());
		}else{
			System.out.println("il est null");
		}

	}


	private void affichage(){
		if(currentClient.getNom().equals(particulier.getNom())){
			nom=particulier.getNom();
			telephone=particulier.getTelephone();
			adresse=particulier.getAdresse();
			email=particulier.getEmail();
			maVille=particulier.getVille().getNom();
		}
		if(currentClient.getNom().equals(entreprise.getNom())){
			System.out.println("ds entreprise");
			nom=entreprise.getNom();
			telephone=entreprise.getTelephone();
			adresse=entreprise.getAdresse();
			email=entreprise.getEmail();
			maVille=entreprise.getVille().getNom();
		}
	}

	public void setCalendar(){
		if(duree!=null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			switch (Integer.parseInt(duree)) {
			case 1:
				quittance.setDateDebut(cal.getTime());
				cal.add(Calendar.MONTH, 1);
				quittance.setDateFin(cal.getTime());
				break;
			case 3:
				quittance.setDateDebut(cal.getTime());
				cal.add(Calendar.MONTH, 3);
				quittance.setDateFin(cal.getTime());
				break;
			case 6:
				quittance.setDateDebut(cal.getTime());
				cal.add(Calendar.MONTH, 6);
				quittance.setDateFin(cal.getTime());
				break;
			case 12:
				quittance.setDateDebut(cal.getTime());
				cal.add(Calendar.MONTH, 12);
				quittance.setDateFin(cal.getTime());
				break;
			}

		}

		System.out.println("ok");
	}





	//-----------------------getters et setters------------------------

	public ClientDAO getClientDAO() {
		return clientDAO;
	}


	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}


	public VilleDAO getVilleDAO() {
		return villeDAO;
	}


	public void setVilleDAO(VilleDAO villeDAO) {
		this.villeDAO = villeDAO;
	}


	public AffaireDAO getAffaireDAO() {
		return affaireDAO;
	}


	public void setAffaireDAO(AffaireDAO affaireDAO) {
		this.affaireDAO = affaireDAO;
	}


	public CompagnieDAO getCompagnieDAO() {
		return compagnieDAO;
	}


	public void setCompagnieDAO(CompagnieDAO compagnieDAO) {
		this.compagnieDAO = compagnieDAO;
	}


	public BrancheDAO getBrancheDAO() {
		return brancheDAO;
	}


	public void setBrancheDAO(BrancheDAO brancheDAO) {
		this.brancheDAO = brancheDAO;
	}


	public TypeQuittanceDAO getTypeQuittanceDAO() {
		return typeQuittanceDAO;
	}


	public void setTypeQuittanceDAO(TypeQuittanceDAO typeQuittanceDAO) {
		this.typeQuittanceDAO = typeQuittanceDAO;
	}


	public AgentDAO getAgentDAO() {
		return agentDAO;
	}


	public void setAgentDAO(AgentDAO agentDAO) {
		this.agentDAO = agentDAO;
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


	public Ville getLaVille() {
		return laVille;
	}


	public void setLaVille(Ville laVille) {
		this.laVille = laVille;
	}


	public String getDuree() {
		return duree;
	}


	public void setDuree(String duree) {
		this.duree = duree;
	}


	public String getTypeClient() {
		return typeClient;
	}


	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}


	public Client getCurrentClient() {
		return currentClient;
	}


	public void setCurrentClient(Client currentClient) {
		this.currentClient = currentClient;
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


	public Affaire getAffaire() {
		return affaire;
	}


	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}


	public Quittance getQuittance() {
		return quittance;
	}


	public void setQuittance(Quittance quittance) {
		this.quittance = quittance;
	}


	public String getBrancheId() {
		return brancheId;
	}


	public void setBrancheId(String brancheId) {
		this.brancheId = brancheId;
	}


	public String getCodeAgent() {
		return codeAgent;
	}


	public void setCodeAgent(String codeAgent) {
		this.codeAgent = codeAgent;
	}


	public String getCompagnie() {
		return compagnie;
	}


	public void setCompagnie(String compagnie) {
		this.compagnie = compagnie;
	}


	public String getTypeQui() {
		return typeQui;
	}


	public void setTypeQui(String typeQui) {
		this.typeQui = typeQui;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
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


	public List<Compagnie> getCompagnies() {
		return compagnies;
	}


	public void setCompagnies(List<Compagnie> compagnies) {
		this.compagnies = compagnies;
	}


	public List<Ville> getVilles() {
		return villes;
	}


	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}


	public List<Branche> getBranches() {
		return branches;
	}


	public void setBranches(List<Branche> branches) {
		this.branches = branches;
	}


	public List<TypeQuittance> getTypeQuittances() {
		return typeQuittances;
	}



	public void setTypeQuittances(List<TypeQuittance> typeQuittances) {
		this.typeQuittances = typeQuittances;
	}


	public List<Categorie> getCategories() {
		return categories;
	}


	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}


	public List<Garantie> getGaranties() {
		return garanties;
	}


	public void setGaranties(List<Garantie> garanties) {
		this.garanties = garanties;
	}


	public String getRefag() {
		return refag;
	}


	public void setRefag(String refag) {
		this.refag = refag;
	}


	public String getContrat() {
		return contrat;
	}


	public void setContrat(String contrat) {
		this.contrat = contrat;
	}

	public double getPrimeTotale() {
		return primeTotale;
	}


	public void setPrimeTotale(double primeTotale) {
		this.primeTotale = primeTotale;
	}


	public boolean isGratuit() {
		return gratuit;
	}


	public void setGratuit(boolean gratuit) {
		this.gratuit = gratuit;
	}


	public List<LigneGarantie> getLigneGaranties() {
		return ligneGaranties;
	}


	public void setLigneGaranties(List<LigneGarantie> ligneGaranties) {
		this.ligneGaranties = ligneGaranties;
	}


	public LigneGarantie getlGarantie() {
		return lGarantie;
	}


	public void setlGarantie(LigneGarantie lGarantie) {
		this.lGarantie = lGarantie;
	}




}
