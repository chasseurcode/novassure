package ma.novassure.domaine;

import java.util.Date;

/**
 * @author TARAM & BODIE
 */
public class Paiement {
	
    public Paiement() {
    }

    private int id;
    private double montant;
    private Date datePaiement;
    private String mode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Date getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
    
    

}