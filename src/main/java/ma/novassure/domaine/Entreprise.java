package ma.novassure.domaine;


/**
 * @author TARAM & BODIE
 */
public class Entreprise extends Client {

    public Entreprise() {
    }

    private String nrc;
    private String patente;
    private String raisonSociale;
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