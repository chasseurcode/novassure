package ma.novassure.beans;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ma.novassure.dao.AffaireDAO;
import ma.novassure.daoimpl.AffaireDAOImpl;
import ma.novassure.domaine.Affaire;
import ma.novassure.domaine.Entreprise;
import ma.novassure.domaine.Particulier;
import ma.novassure.domaine.Quittance;
import ma.novassure.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class QuittanceBean {
	private String numPolice;
	private Quittance quittance;
	private List<Quittance> listQuittances;
	private AffaireDAO dao;
	
	public QuittanceBean() {
		setDao(new AffaireDAOImpl(HibernateUtil.getSession()));
		//setQuittance(dao.findQuittanceByNumPolice(numPolice));
		initLast();
	}
	
	public String getNumPolice() {
		return numPolice;
	}

	public void setNumPolice(String numPolice) {
		this.numPolice = numPolice;
	}

	public Quittance getQuittance() {
		return quittance;
	}

	public void setQuittance(Quittance quittance) {
		this.quittance = quittance;
	}
	
	private List<Quittance> initLast() {
		ArrayList<Quittance> dernier=new ArrayList<Quittance>();
		Entreprise entrep2=new Entreprise();
		 entrep2.setNom("BoniSoft");
		entrep2.setTelephone("002992333");
		
		Particulier part1=new Particulier();
		part1.setNom("Sanogo");
		part1.setPrenom("Sori");
		
		try {
			Affaire aff=new Affaire();
			aff.setClient(part1);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Quittance q4=new Quittance();
			q4.setAffaire(aff);
			q4.setNumPolice("NA321443321233");
			q4.setDateDebut(sdf.parse("16/09/2014"));
			q4.setDateFin(sdf.parse("20/09/2014"));

			setQuittance(q4);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dernier;
	}

	public List<Quittance> getListQuittances() {
		return listQuittances;
	}

	public void setListQuittances(List<Quittance> listQuittances) {
		this.listQuittances = listQuittances;
	}

	public AffaireDAO getDao() {
		return dao;
	}

	public void setDao(AffaireDAO dao) {
		this.dao = dao;
	}
}
