package ma.novassure.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author TARAM & BODIE
 */
@Entity
public class TypeQuittance {


	@Id @GeneratedValue
	private int id;
	private String libelle;

	public TypeQuittance() {
	}
	
	
	public TypeQuittance(String libelle) {
		super();
		this.libelle = libelle;
	}


	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}