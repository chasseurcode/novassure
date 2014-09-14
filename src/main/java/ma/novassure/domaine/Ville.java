package ma.novassure.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author TARAM & BODIE
 */
@Entity
public class Ville {


	@Id @GeneratedValue
	private int id;
	private String code;
	private String nom;
	private List<Client> clients;
	private List<Compagnie> compagnies;
	public Ville() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public List<Compagnie> getCompagnies() {
		return compagnies;
	}
	public void setCompagnies(List<Compagnie> compagnies) {
		this.compagnies = compagnies;
	}

}