package ma.novassure.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ma.novassure.dao.BrancheDAO;
import ma.novassure.daoimpl.BrancheDAOImpl;
import ma.novassure.domaine.Branche;
import ma.novassure.domaine.Categorie;
import ma.novassure.domaine.Garantie;
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
	private Categorie currentCatego;
	private Garantie updateGarantie;
	private Garantie garantie;
	private List<Garantie> garanties;
	
	public BrancheBean() {
		setBrancheDAO(new BrancheDAOImpl(HibernateUtil.getSession()));
		refreshList();
		branche=new Branche();
		garantie=new Garantie();
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
		seletedBranche.addCategorie(categorie);
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
	public void setSelectedCatego(Categorie c) {
		setCurrentCatego(c);
		setGaranties(c.getActivedGaranties());
	}

	public void addGarantie() {
		currentCatego.addGarantie(garantie);
		brancheDAO.updateCategorie(currentCatego);
		garantie=new Garantie();
		refreshGaranties();
	}

	public void loadGarantie(Garantie garantie) {
		setUpdateGarantie(garantie);
	}

	public void updateGarantie() {
		for (int i = 0; i < currentCatego.getGaranties().size(); i++) {
			if(currentCatego.getGaranties().get(i).getLibelle().equalsIgnoreCase(updateGarantie.getLibelle())){
				currentCatego.getGaranties().get(i).setLibelle(updateGarantie.getLibelle());
				brancheDAO.updateCategorie(currentCatego);
				setUpdateGarantie(new Garantie());
				refreshGaranties();
				break;
			}
		}
	}

	public void removeGarantie(Garantie garantie) {
		for (int i = 0; i < currentCatego.getGaranties().size(); i++) {
			if(currentCatego.getGaranties().get(i).getLibelle().equalsIgnoreCase(garantie.getLibelle())){
				currentCatego.getGaranties().get(i).setDeleted(true);
				brancheDAO.updateCategorie(currentCatego);
				setUpdateGarantie(new Garantie());
				refreshGaranties();
				break;
			}
		}
	}

	private void refreshGaranties() {
		setGaranties(currentCatego.getActivedGaranties());
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

	public Categorie getCurrentCatego() {
		return currentCatego;
	}

	public void setCurrentCatego(Categorie currentCatego) {
		this.currentCatego = currentCatego;
	}

	public Garantie getGarantie() {
		return garantie;
	}

	public void setGarantie(Garantie garantie) {
		this.garantie = garantie;
	}

	public Garantie getUpdateGarantie() {
		return updateGarantie;
	}

	public void setUpdateGarantie(Garantie updateGarantie) {
		this.updateGarantie = updateGarantie;
	}

	public List<Garantie> getGaranties() {
		return garanties;
	}

	public void setGaranties(List<Garantie> garanties) {
		this.garanties = garanties;
	}     
	
	

}
