package ma.novassure.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * @author TARAM & BODIE
 */
@Entity
public class Agent {
  
	@Id @GeneratedValue
    private int id;
	
    private String code;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Quittance> quittances;
    
    
    public Agent() {
    }
       
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Quittance> getQuittances() {
		return quittances;
	}

	public void setQuittances(List<Quittance> quittances) {
		this.quittances = quittances;
	}
	
}