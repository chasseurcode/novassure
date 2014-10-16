package ma.novassure.domaine;

import java.io.Serializable;
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
public class Branche implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
    private int id;
    private String libelle;
    private boolean activated=true;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Categorie> categories=new ArrayList<Categorie>();
    
    public Branche() {
    }
    
    
	public Branche(String libelle) {
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


	public List<Categorie> getCategories() {
		return categories;
	}


	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}


	public boolean isActivated() {
		return activated;
	}


	public void setActivated(boolean activated) {
		this.activated = activated;
	}
		

}