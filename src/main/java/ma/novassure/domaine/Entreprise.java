package ma.novassure.domaine;

import javax.persistence.Entity;


/**
 * @author TARAM & BODIE
 */
@Entity
public class Entreprise extends Client {
	private String nrc;
	private String patente;
	private String raisonSociale;

	public Entreprise() {
	}


	public Entreprise(String nom, String adresse, 
			Ville ville, String telephone, String email,
			String faxe,String nrc, String patente, 
			String raisonSociale) {
		
		super(nom, adresse, ville, telephone, email, faxe);
		this.nrc=nrc;
		this.patente=patente;
		this.raisonSociale=raisonSociale;
	}


	public String getNrc() {
		return nrc;
	}
	public void setNrc(String nrc) {
		this.nrc = nrc;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

}