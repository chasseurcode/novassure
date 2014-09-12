package ma.novassure.domaine;


/**
 * @author TARAM & BODIE
 */
public class Garantie {
    
    private int id;
    private String libelle;
    private Categorie categorie;
    private Branche branche;
    
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

	public Branche getBranche() {
		return branche;
	}

	public void setBranche(Branche branche) {
		this.branche = branche;
	}
    
}