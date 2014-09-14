package ma.novassure.domaine;

import javax.persistence.Entity;


/**
 * @author TARAM & BODIE
 */

@Entity
public class Particulier extends Client {

    private String prenom;
    private String cin;
    
    public Particulier() {
    }

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