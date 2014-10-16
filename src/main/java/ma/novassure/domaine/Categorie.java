package ma.novassure.domaine;

import java.util.ArrayList;
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
public class Categorie {

	@Id @GeneratedValue
	private int id;
	private String libelle;
	private String code;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Garantie> garanties=new ArrayList<Garantie>();

 public Categorie() {}
	public int getId() {
		return id;
	}
	
	public Categorie(String libelle, String code) {
		this.libelle = libelle;
		this.code = code;
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<Garantie> getGaranties() {
		return garanties;
	}
	public void setGaranties(List<Garantie> garanties) {
		this.garanties = garanties;
	} 
	
	 
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Categorie && ((Categorie) obj).getLibelle().equalsIgnoreCase(this.libelle)) {
				return true;
			}
			return false;
		}
}