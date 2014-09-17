package ma.novassure.domaine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author TARAM & BODIE
 */
@Entity
public class Quittance {

	@Id @GeneratedValue
    private int id;
    private String numero;
    private String numPolice;
    private String numAttestation;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    private Compagnie compagnie;
    @ManyToOne
    private TypeQuittance typeQuittance;
    @ManyToOne
    private Agent agent;
    @OneToMany
    private List<LigneGarantie> garanties;
    @ManyToOne
     private Affaire affaire;
    
    public Quittance() {
    	garanties=new ArrayList<LigneGarantie>();
    }
    
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
	
	public Agent getAgent() {
		return agent;
	}
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	public List<LigneGarantie> getGaranties() {
		return garanties;
	}
	
	public void setGaranties(List<LigneGarantie> garanties) {
		this.garanties = garanties;
	}

	public TypeQuittance getTypeQuittance() {
		return typeQuittance;
	}

	public void setTypeQuittance(TypeQuittance typeQuittance) {
		this.typeQuittance = typeQuittance;
	}

	public Compagnie getCompagnie() {
		return compagnie;
	}

	public void setCompagnie(Compagnie compagnie) {
		this.compagnie = compagnie;
	}

	public Affaire getAffaire() {
		return affaire;
	}

	public void setAffaire(Affaire affaire) {
		this.affaire = affaire;
	}
    
	
}