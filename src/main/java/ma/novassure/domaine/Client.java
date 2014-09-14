package ma.novassure.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * @author TARAM & BODIE
 */

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Client {

	@Id @GeneratedValue
	private int id;
	protected String nom;
	protected String adresse;
	@ManyToOne
	protected Ville ville;
	protected String telephone;
	protected String email;
	protected String faxe;
	@OneToMany
	private List<Affaire> affaires;


	public Client() {
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFaxe() {
		return faxe;
	}
	public void setFaxe(String faxe) {
		this.faxe = faxe;
	}

	public List<Affaire> getAffaires() {
		return affaires;
	}

	public void setAffaires(List<Affaire> affaires) {
		this.affaires = affaires;
	}

}