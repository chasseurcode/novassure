package ma.novassure.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import ma.novassure.domaine.Document;
import ma.novassure.domaine.Entreprise;
import ma.novassure.domaine.Garantie;
import ma.novassure.domaine.LigneGarantie;
import ma.novassure.domaine.Paiement;
import ma.novassure.domaine.Particulier;
import ma.novassure.domaine.Quittance;
import ma.novassure.domaine.TypeQuittance;
import ma.novassure.domaine.Ville;
import ma.novassure.utils.HibernateUtil;

import org.primefaces.event.FileUploadEvent;
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
	private List<Quittance> quittances;
	private  LigneGarantie lGarantie;
	private double primeTotale;
	private boolean gratuit;
	private Document document;
	private Paiement paiement;
	private List<Paiement> paiements;
	private double resteaPayer;
	private double payer;
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
		document=new Document();
		paiement=new Paiement();
		paiements=new ArrayList<Paiement>();
		ligneGaranties=new ArrayList<LigneGarantie>();
		garanties=new ArrayList<Garantie>();
		branches=new ArrayList<Branche>();
		villes=new ArrayList<Ville>();
		compagnies=new ArrayList<Compagnie>();
		categories=new ArrayList<Categorie>();
		typeQuittances=new ArrayList<TypeQuittance>();
		quittances=new ArrayList<Quittance>();
		typeQuittances=typeQuittanceDAO.findAllEnabledTypes();
		branches=brancheDAO.findAllBranches();
		villes=villeDAO.findAllVille();
		compagnies=compagnieDAO.findAllCompagnies();
		setPrimeTotale(1);
	}
	
	/**
	 * 
	 * Gestion du client
	 */


	public void searchParticulier(ActionEvent event){
		particuliers=new ArrayList<Particulier>();
		particulier=clientDAO.findClientByCin(myCin);
		currentClient=particulier;
		if(particulier!=null)
			particuliers.add(particulier);

	}

	public void searchEntreprise(ActionEvent event){
		entreprises=new ArrayList<Entreprise>();
		entreprise=clientDAO.findClientByNrc(myNrc);
		currentClient=entreprise;
		if(entreprise!=null)
			entreprises.add(entreprise);	
	}

	public void clear(){
		particuliers=new ArrayList<Particulier>();
		entreprises=new ArrayList<Entreprise>();
		particulier=new Particulier();
		entreprise=new Entreprise(); 
		currentClient=null;
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

	
	/****
	 * Gestion des quittances
	 */
	public void addQuittance(){
		if(compagnie!=null && typeQui!=null && codeAgent!=null && categorie!=null){
			System.out.println("cest bon");
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
			for(LigneGarantie lg:ligneGaranties){
				lg.setQuittance(quittance);
				quittance.getGaranties().add(lg); 
			}
			affaire.addQuittance(quittance);	
			quittances.add(quittance);
		}
	}

	public void loadQuittance(Quittance quittance){
		System.out.println("entrer et load");
		setQuittance(quittance);
		ligneGaranties=new ArrayList<LigneGarantie>();
		quittances.remove(quittance);
	}

	public void removeQuittance(Quittance quittance){
		System.out.println("entrer et supp "+quittance.getNumPolice());
		System.out.println(affaire.getQuittances().size());
		affaire.getQuittances().remove(quittance);
		System.out.println(affaire.getQuittances().size());

	}

	public void addNewQuittance(){
		System.out.println("ds new garantie");
		quittance=new Quittance();
		garanties=new ArrayList<Garantie>();
		ligneGaranties=new ArrayList<LigneGarantie>();
		categories=new ArrayList<Categorie>();
		typeQuittances=new ArrayList<TypeQuittance>();
		typeQuittances=typeQuittanceDAO.findAllEnabledTypes();
		branches=new ArrayList<Branche>();
		branches=brancheDAO.findAllBranches();
		compagnies=new ArrayList<Compagnie>();
		compagnies=compagnieDAO.findAllCompagnies();
		codeAgent="";
	}

	public void saveAndQuit(){
		affaireDAO.createAffaire(affaire);
	}

	public void onCellEdit(LigneGarantie garantie){

		setPrimeTotale(garantie.getAccessoire()+garantie.getCommission()+
				garantie.getPrimeNette()+garantie.getTaxe()+garantie.getTimbre());

		System.out.println(getPrimeTotale());		
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
		quittances=new ArrayList<Quittance>();
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
	}

	public String getBrancheName(Quittance quittance){
		Garantie ga=quittance.getGaranties().get(0).getGarantie();
		System.out.println("la ga : "+ga.getLibelle());
		Categorie c=ga.getCategorie();
		System.out.println(" catego: "+c.getLibelle());
		Branche b=c.getBranche();
		System.out.println("branche : "+b.getLibelle());
		return b.getLibelle();

	}

	public String getCategorieName(Quittance quittance){
		Garantie ga=quittance.getGaranties().get(0).getGarantie();
		System.out.println("la ga : "+ga.getLibelle());
		Categorie c=ga.getCategorie();

		return c.getLibelle();
	}

	/**
	 * 
	 * progression du wizard
	 */
	public String onFlowProcess(FlowEvent event) {
		affichage();
		affaire.setClient(currentClient);
		affaire.setStep(affaire.getStep()+1);
		return event.getNewStep();		
	}

	/****
	 * 
	 * Gestion des documents
	 */

	public void addDoc(FileUploadEvent event){
		System.out.println("ds add doc");
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	 private void copyFile(String fileName, InputStream in) {
		
		try {


			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(fileName));
                   System.out.println(getClass().getResource("/documents/test.text").getPath());
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			document.setTitre(fileName);
			System.out.println(document.getTitre());
			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public void download(){
		
	}
	
	
	/**
	 * 
	 * Gestion de paiement
	 */

	public void loadPaiement(Paiement paiement){
		System.out.println("load paiemnt");
		setPaiement(paiement);
	}

	public void removePaiement(Paiement paiement){
		System.out.println("remove paiement");
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


	public List<Quittance> getQuittances() {
		return quittances;
	}


	public void setQuittances(List<Quittance> quittances) {
		this.quittances = quittances;
	}


	public Document getDocument() {
		return document;
	}


	public void setDocument(Document document) {
		this.document = document;
	}


	public Paiement getPaiement() {
		return paiement;
	}


	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}


	public double getResteaPayer() {
		return resteaPayer;
	}


	public void setResteaPayer(double resteaPayer) {
		this.resteaPayer = resteaPayer;
	}


	public double getPayer() {
		return payer;
	}


	public void setPayer(double payer) {
		this.payer = payer;
	}


	public List<Paiement> getPaiements() {
		return paiements;
	}


	public void setPaiements(List<Paiement> paiements) {
		this.paiements = paiements;
	}




}
