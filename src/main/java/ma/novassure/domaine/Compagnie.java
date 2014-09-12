package ma.novassure.domaine;


/**
 * @author TARAM & BODIE
 */
public class Compagnie {

    private String code;
    private String telephone;
    private String adresse;
    private String ville;
    private String faxe;
    private String nom;
    
    public Compagnie() {
    }
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getFaxe() {
		return faxe;
	}
	public void setFaxe(String faxe) {
		this.faxe = faxe;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
    
}