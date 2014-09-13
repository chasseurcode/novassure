package ma.novassure.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author TARAM & BODIE
 */

@Entity
public class Particulier extends Client {


    @Id @GeneratedValue
    private int id;
    private String prenom;
    private String cin;
    

    public Particulier() {
    }
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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