package ma.novassure.domaine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * @author TARAM & BODIE
 */
@Entity
public class Categorie {

	@Id @GeneratedValue
	private int id;
	private String libelle;
	@ManyToOne
	private Branche branche;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Garantie> garanties=new ArrayList<Garantie>();

	public Categorie() {}
	public int getId() {
		return id;
	}

	public Categorie(String libelle) {
		this.libelle = libelle;
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
	
	public Branche getBranche() {
		return branche;
	}
	public void setBranche(Branche branche) {
		this.branche = branche;
	}
	public List<Garantie> getGaranties() {
		return garanties;
	}
	public void setGaranties(List<Garantie> garanties) {
		this.garanties = garanties;
	} 

	public List<Garantie> getActivedGaranties() {
		List<Garantie> gaList=new ArrayList<Garantie>();
		for(Garantie g: this.garanties){
			if(!g.isDeleted())
				gaList.add(g);
		}
		return gaList;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Categorie && ((Categorie) obj).getLibelle().equalsIgnoreCase(this.libelle)) {
			return true;
		}
		return false;
	}
	
	public void addGarantie(Garantie garantie){
		garantie.setCategorie(this);
		garanties.add(garantie);
	}
}