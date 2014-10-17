package ma.novassure.domaine;

import javax.persistence.CascadeType;
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
	private boolean deleted=false;
	@ManyToOne(cascade=CascadeType.ALL)
	private Categorie categorie;

	public Garantie() {
	}
	
	
	public Garantie(String libelle) {
		super();
		this.libelle = libelle;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}