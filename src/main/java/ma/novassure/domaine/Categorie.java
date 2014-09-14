package ma.novassure.domaine;

import java.util.List;

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
    private int code;
    @OneToMany
    private List<Garantie> garanties;
    
    
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
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<Garantie> getGaranties() {
		return garanties;
	}
	public void setGaranties(List<Garantie> garanties) {
		this.garanties = garanties;
	} 
	
}