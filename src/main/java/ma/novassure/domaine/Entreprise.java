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