package ma.novassure.beans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ma.novassure.domaine.Affaire;
import ma.novassure.domaine.Entreprise;
import ma.novassure.domaine.Particulier;
import ma.novassure.domaine.Quittance;

@ManagedBean
@SessionScoped
public class HomeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Quittance> lastQuittances;
	private List<Quittance> echeances;
	
	public HomeBean() {
		lastQuittances=initLast();
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
			
			Quittance q2=new Quittance();
			q2.setAffaire(aff);
			q2.setNumPolice("NA321443321233");
			q2.setDateDebut(sdf.parse("16/09/2014"));
			q2.setDateFin(sdf.parse("18/09/2014"));
			
			Quittance q3=new Quittance();
			q3.setAffaire(aff);
			q3.setNumPolice("NA321443321233");
			q3.setDateDebut(sdf.parse("16/09/2014"));
			q3.setDateFin(sdf.parse("19/09/2014"));
			
			Quittance q31=new Quittance();
			q31.setAffaire(aff);
			q31.setNumPolice("NA321443321233");
			q31.setDateDebut(sdf.parse("16/09/2014"));
			q31.setDateFin(sdf.parse("30/09/2014"));
			
			Quittance q41=new Quittance();
			q41.setAffaire(aff);
			q41.setNumPolice("NA321443321233");
			q41.setDateDebut(sdf.parse("16/09/2014"));
			q41.setDateFin(sdf.parse("22/09/2014"));
			
			dernier.add(q4);
			dernier.add(q2);
			dernier.add(q3);
			dernier.add(q31);
			dernier.add(q41);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return dernier;
	}
	
	public List<Quittance> getLastQuittances() {
		return lastQuittances;
	}

	public void setLastQuittances(List<Quittance> lastQuittances) {
		this.lastQuittances = lastQuittances;
	}

	public List<Quittance> getEcheances() {
		return echeances;
	}

	public void setEcheances(List<Quittance> echeances) {
		this.echeances = echeances;
	}
	
	public long joursRestant(Quittance quittance) {
		return ((new Date()).getTime()-quittance.getDateFin().getTime())/1000/60/60/24;
	}
}
