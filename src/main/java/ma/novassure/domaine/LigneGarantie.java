package ma.novassure.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author TARAM & BODIE
 */

@Entity
public class LigneGarantie {


	@Id @GeneratedValue
	private int id;
	private double primeNette;
	private double accessoire;
	private double timbre;
	private double taxe;
	private double commission;
	private Garantie garantie;
	private Quittance quittance;

	public LigneGarantie() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrimeNette() {
		return primeNette;
	}
	public void setPrimeNette(double primeNette) {
		this.primeNette = primeNette;
	}
	public double getAccessoire() {
		return accessoire;
	}
	public void setAccessoire(double accessoire) {
		this.accessoire = accessoire;
	}
	public double getTimbre() {
		return timbre;
	}
	public void setTimbre(double timbre) {
		this.timbre = timbre;
	}
	public double getTaxe() {
		return taxe;
	}
	public void setTaxe(double taxe) {
		this.taxe = taxe;
	}
	public double getCommission() {
		return commission;
	}
	public void setCommission(double commission) {
		this.commission = commission;
	}

	public Garantie getGarantie() {
		return garantie;
	}

	public void setGarantie(Garantie garantie) {
		this.garantie = garantie;
	}

	public Quittance getQuittance() {
		return quittance;
	}

	public void setQuittance(Quittance quittance) {
		this.quittance = quittance;
	}
	
}