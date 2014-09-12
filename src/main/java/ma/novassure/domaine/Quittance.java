package ma.novassure.domaine;

import java.util.Date;

/**
 * @author TARAM & BODIE
 */
public class Quittance {

    public Quittance() {
    }

    private int id;
    private String numero;
    private String numPolice;
    private String numAttestation;
    private Date dateDebut;
    private Date dateFin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNumPolice() {
		return numPolice;
	}
	public void setNumPolice(String numPolice) {
		this.numPolice = numPolice;
	}
	public String getNumAttestation() {
		return numAttestation;
	}
	public void setNumAttestation(String numAttestation) {
		this.numAttestation = numAttestation;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
    
}