package ma.novassure.domaine;


/**
 * @author TARAM & BODIE
 */
public class LigneGarantie {

    public LigneGarantie() {
    }

    private int id;
    private double primeNette;
    private double accessoire;
    private double timbre;
    private double taxe;
    private double commission;
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

}