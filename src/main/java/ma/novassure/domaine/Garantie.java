package ma.novassure.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/**
 * @author TARAM & BODIE
 */

@Entity
public class Garantie {

	@Id @GeneratedValue
	private int id;
	private String libelle;
	@ManyToOne
	private Categorie categorie;

	public Garantie() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

}