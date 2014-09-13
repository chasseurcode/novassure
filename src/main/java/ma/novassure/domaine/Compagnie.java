package ma.novassure.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author TARAM & BODIE
 */
@Entity
public class Compagnie {

	@Id @GeneratedValue
	private int id;
    private String code;
    private String telephone;
    private String adresse;
    private Ville ville;
    private String faxe;
    private String nom;
    
    public Compagnie() {
    }
     
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
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