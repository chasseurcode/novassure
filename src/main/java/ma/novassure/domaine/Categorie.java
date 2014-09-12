package ma.novassure.domaine;


/**
 * @author TARAM & BODIE
 */
public class Categorie {
    public Categorie() {
    }

    private String libelle;
    private int code;
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
}