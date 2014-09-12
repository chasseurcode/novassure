package ma.novassure.domaine;


/**
 * @author TARAM & BODIE
 */
public class Particulier extends Client {


    public Particulier() {
    }

    private String prenom;
    private String cin;
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
  
}