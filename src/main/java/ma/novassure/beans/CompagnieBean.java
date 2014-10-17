package ma.novassure.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ma.novassure.dao.CompagnieDAO;
import ma.novassure.dao.VilleDAO;
import ma.novassure.daoimpl.CompagnieDAOImpl;
import ma.novassure.daoimpl.VilleDAOImpl;
import ma.novassure.domaine.Compagnie;
import ma.novassure.domaine.Ville;
import ma.novassure.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class CompagnieBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private CompagnieDAO dao;
	private VilleDAO daoVille;
	private List<Compagnie> compagnies;
	private Compagnie compagnie;
	private  List<Ville> villes;
	private String selectedVille;
	
	public CompagnieBean() {
		dao=new CompagnieDAOImpl(HibernateUtil.getSession());
		daoVille=new VilleDAOImpl(HibernateUtil.getSession());
		compagnie=new Compagnie();
		refreshCompagnieList();
	}
	
	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	private void refreshCompagnieList() {
		setCompagnies(dao.findAllEnabledCompagnies());
		setVilles(daoVille.findAllVille());
	}
	public void addCompagnie() {
		Ville compVille=daoVille.findVilleById(Integer.parseInt(selectedVille));
		compagnie.setVille(compVille);
		dao.addCompagnie(compagnie);
		compagnie=new Compagnie();
		refreshCompagnieList();
	}
	
	public void updateCompagnie() {
		dao.updateCompagnie(compagnie);
		refreshCompagnieList();
		compagnie=new Compagnie();
	}
	
	public void load(Compagnie c) {
		setCompagnie(c);
	}
	public void removeCompagnie(Compagnie c) {
		c.setEnabled(false);
		dao.updateCompagnie(c);
		refreshCompagnieList();
	}
	
	public Compagnie getCompagnie() {
		return compagnie;
	}
	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}
	public List<Compagnie> getCompagnies() {
		return compagnies;
	}
	
	public void setCompagnies(List<Compagnie> compagnies) {
		this.compagnies = compagnies;
	}
	

	public String getSelectedVille() {
		return selectedVille;
	}

	public void setSelectedVille(String selectedVille) {
		this.selectedVille = selectedVille;
	}

	public CompagnieDAO getDao() {
		return dao;
	}

	public void setDao(CompagnieDAO dao) {
		this.dao = dao;
	}

}
