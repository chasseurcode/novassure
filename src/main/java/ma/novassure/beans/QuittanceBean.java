package ma.novassure.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ma.novassure.dao.AffaireDAO;
import ma.novassure.dao.BrancheDAO;
import ma.novassure.dao.CategorieDAO;
import ma.novassure.dao.CompagnieDAO;
import ma.novassure.dao.TypeQuittanceDAO;
import ma.novassure.dao.VilleDAO;
import ma.novassure.daoimpl.AffaireDAOImpl;
import ma.novassure.daoimpl.BrancheDAOImpl;
import ma.novassure.daoimpl.CategorieDAOImpl;
import ma.novassure.daoimpl.TypeQuittanceDAOImpl;
import ma.novassure.daoimpl.VilleDAOImpl;
import ma.novassure.domaine.Affaire;
import ma.novassure.domaine.Branche;
import ma.novassure.domaine.Categorie;
import ma.novassure.domaine.Compagnie;
import ma.novassure.domaine.LigneGarantie;
import ma.novassure.domaine.Quittance;
import ma.novassure.domaine.TypeQuittance;
import ma.novassure.domaine.Ville;
import ma.novassure.utils.HibernateUtil;

@ManagedBean
@ViewScoped
public class QuittanceBean {
	private CompagnieDAO compagnieDAO;
	private AffaireDAO affaireDAO;
	private VilleDAO villeDAO;
	private BrancheDAO brancheDAO;
	private TypeQuittanceDAO typeQuittanceDAO;
	private CategorieDAO categorieDAO;
	private Compagnie laCompagnie;
	private String compagnieFictive;
    private String codeAgent;
    private String nPolice;
    private String nAttestation;
    private String contrat;
    private Quittance nQuittance;
    private String numQui;
    private String refAgent;
    private TypeQuittance typeQui;
    private String periode;
    private Date dateDebut, dateFin;
    private Branche branche;
    private Categorie categorie;
    private List<Categorie> categories;
    private Affaire affaire;
    private List<TypeQuittance>typeQuittances;
    private List<Branche> branches;
    private List<LigneGarantie>ligneGaranties;
    //fictif
	private List<Compagnie> compagnies;
	private Ville maVille;


	public QuittanceBean() {
		affaireDAO=new AffaireDAOImpl(HibernateUtil.getSession());
		villeDAO=new VilleDAOImpl(HibernateUtil.getSession());
		typeQuittanceDAO= new TypeQuittanceDAOImpl(HibernateUtil.getSession());
		brancheDAO=new BrancheDAOImpl(HibernateUtil.getSession());
		categorieDAO= new CategorieDAOImpl(HibernateUtil.getSession());
		categories=new ArrayList<Categorie>();
		categories=categorieDAO.findAllCategories();
		branches=brancheDAO.findAllBranches();
		compagnies=new ArrayList<Compagnie>();
		typeQuittances=new ArrayList<TypeQuittance>();
		typeQuittances=typeQuittanceDAO.findAllTypes();
		init();
		
	}
	
	
	public List<String> autoCompletionCompagnie(String name){
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(name + i);
        }
           return results;
	}
	
	

	
	public CompagnieDAO getCompagnieDAO() {
		return compagnieDAO;
	}
	
	public void addQuittance(){
		System.out.println("save-------------->>");
	
	}
	
	
	//-----------------------getters et setters------------------------


	public void setCompagnieDAO(CompagnieDAO compagnieDAO) {
		this.compagnieDAO = compagnieDAO;
	}


	public AffaireDAO getAffaireDAO() {
		return affaireDAO;
	}


	public void setAffaireDAO(AffaireDAO affaireDAO) {
		this.affaireDAO = affaireDAO;
	}


	public List<Compagnie> getCompagnies() {
		return compagnies;
	}


	public void setCompagnies(List<Compagnie> compagnies) {
		this.compagnies = compagnies;
	}


	public Compagnie getLaCompagnie() {
		return laCompagnie;
	}


	public void setLaCompagnie(Compagnie laCompagnie) {
		this.laCompagnie = laCompagnie;
	}


	public String getCompagnieFictive() {
		return compagnieFictive;
	}


	public void setCompagnieFictive(String compagnieFictive) {
		this.compagnieFictive = compagnieFictive;
	}


	


	public String getnPolice() {
		return nPolice;
	}


	public void setnPolice(String nPolice) {
		this.nPolice = nPolice;
	}


	public String getnAttestation() {
		return nAttestation;
	}


	public void setnAttestation(String nAttestation) {
		this.nAttestation = nAttestation;
	}


	public String getContrat() {
		return contrat;
	}


	public void setContrat(String contrat) {
		this.contrat = contrat;
	}


	public Quittance getnQuittance() {
		return nQuittance;
	}


	public void setnQuittance(Quittance nQuittance) {
		this.nQuittance = nQuittance;
	}


	public String getRefAgent() {
		return refAgent;
	}


	public void setRefAgent(String refAgent) {
		this.refAgent = refAgent;
	}


	public TypeQuittance getTypeQui() {
		return typeQui;
	}


	public void setTypeQui(TypeQuittance typeQui) {
		this.typeQui = typeQui;
	}


	public String getPeriode() {
		return periode;
	}


	public void setPeriode(String periode) {
		this.periode = periode;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	


	public Affaire getAffaire() {
		return affaire;
	}


	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}


	public String getNumQui() {
		return numQui;
	}


	public void setNumQui(String numQui) {
		this.numQui = numQui;
	}
	

	public VilleDAO getVilleDAO() {
		return villeDAO;
	}


	public void setVilleDAO(VilleDAO villeDAO) {
		this.villeDAO = villeDAO;
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


	public CategorieDAO getCategorieDAO() {
		return categorieDAO;
	}


	public void setCategorieDAO(CategorieDAO categorieDAO) {
		this.categorieDAO = categorieDAO;
	}


	public String getCodeAgent() {
		return codeAgent;
	}


	public void setCodeAgent(String codeAgent) {
		this.codeAgent = codeAgent;
	}


	public Branche getBranche() {
		return branche;
	}


	public void setBranche(Branche branche) {
		this.branche = branche;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public List<Categorie> getCategories() {
		return categories;
	}


	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}


	public List<TypeQuittance> getTypeQuittances() {
		return typeQuittances;
	}


	public void setTypeQuittances(List<TypeQuittance> typeQuittances) {
		this.typeQuittances = typeQuittances;
	}


	public List<Branche> getBranches() {
		return branches;
	}


	public void setBranches(List<Branche> branches) {
		this.branches = branches;
	}


	public Ville getMaVille() {
		return maVille;
	}


	public void setMaVille(Ville maVille) {
		this.maVille = maVille;
	}


	private void init(){
		Compagnie comp=new Compagnie();
		comp.setCode("goog");
		comp.setFaxe("--");
		comp.setNom("google");
		comp.setVille(maVille);
		comp.setEnabled(true);
		compagnies.add(comp);
		
		comp=new Compagnie();
		comp.setCode("Axa");
		comp.setFaxe("--");
		comp.setNom("axa");
		comp.setVille(maVille);
		comp.setEnabled(true);
		compagnies.add(comp);
		
		
	}
	
	
	
}
