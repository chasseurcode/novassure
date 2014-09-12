package ma.novassure.domaine;


/**
 * @author TARAM & BODIE
 */
public class Document {
    public Document() {
    }

    private int id;
    private String titre;
    private String chemin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getChemin() {
		return chemin;
	}
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

}