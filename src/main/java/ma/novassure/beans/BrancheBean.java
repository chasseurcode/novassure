package ma.novassure.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ma.novassure.dao.BrancheDAO;
import ma.novassure.daoimpl.BrancheDAOImpl;
import ma.novassure.domaine.Branche;
import ma.novassure.domaine.Categorie;
import ma.novassure.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class BrancheBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Branche> branches;
	private Branche branche;
	private BrancheDAO brancheDAO;
	private Categorie categorie;
	private Branche seletedBranche;
	private Categorie selectedCat;

	public BrancheBean() {
		setBrancheDAO(new BrancheDAOImpl(HibernateUtil.getSession()));
		refreshList();
		branche=new Branche();
		seletedBranche=new Branche();
	}

	private void refreshList() {
		setBranches(brancheDAO.findAllActivedBranches());
		branche=new Branche();
	}

	/*
	 * Gestion des branches
	 */

	public void addBranche() {
		if (branche!=null) {
			brancheDAO.addBranche(branche);
		}
		refreshList();
	}

	public void updateBranche() {
		if (branche!=null) {
			brancheDAO.updateBranche(branche);
		}
		refreshList();
	}

	public void removeBranche(Branche branche) {
		branche.setActivated(false);
		brancheDAO.updateBranche(branche);
		refreshList();
	}

	public void loadCategorie(Categorie cat) {
		setCategorie(cat);
	}

	public void load(Branche branche) {
		setBranche(branche);
	}


	/*
	 * Gestion des catégories d'une branche
	 */
	public void setSelectedBranche(Branche branche) {
		setSeletedBranche(branche);
		setCategorie(new Categorie());
	}

	public void addCategorie() {
		seletedBranche.getCategories().add(categorie);
		brancheDAO.updateBranche(seletedBranche);
	}

	public void updateCategorie() {
		System.out.println(categorie.getLibelle());
		for(int i=0;i<seletedBranche.getCategories().size();i++){
			Categorie c=seletedBranche.getCategories().get(i);
			if (c.getLibelle().equalsIgnoreCase(categorie.getLibelle())) {
				seletedBranche.getCategories().get(i).setLibelle(categorie.getLibelle());
				brancheDAO.updateBranche(seletedBranche);
				break;
			}
		}
		refreshList();
	}

	public void removeCategorie(Branche br,Categorie categorie) {
		br.getCategories().remove(categorie);
		brancheDAO.updateBranche(br);
		refreshList();
	}

	/*
	 * Gestion des garanties
	 */
	public void setSelectedCategorie(Categorie c) {
		setSelectedCategorie(c);
		System.out.println(c.getLibelle());
	}
	
	/*
	 * Getter & Setter
	 */
	public List<Branche> getBranches() {
		return branches;
	}

	public void setBranches(List<Branche> branches) {
		this.branches = branches;
	}

	public Branche getBranche() {
		return branche;
	}

	public void setBranche(Branche branche) {
		this.branche = branche;
	}

	public BrancheDAO getBrancheDAO() {
		return brancheDAO;
	}

	public void setBrancheDAO(BrancheDAO brancheDAO) {
		this.brancheDAO = brancheDAO;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Branche getSeletedBranche() {
		return seletedBranche;
	}

	public void setSeletedBranche(Branche seletedBranche) {
		this.seletedBranche = seletedBranche;
	}

	public Categorie getSelectedCat() {
		return selectedCat;
	}
	
	
}
