package ma.novassure.domaine;

import javax.persistence.Column;
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
	@Column(unique=true)
	private String libelle;
	private boolean deleted=false;

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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}