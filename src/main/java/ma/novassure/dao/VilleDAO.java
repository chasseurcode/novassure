package ma.novassure.dao;

import java.util.List;

import ma.novassure.domaine.Ville;

/**
 * 
 */
public interface VilleDAO {

	public Ville addVille(Ville ville);

	public void updateVille(Ville ville);

	public Ville findVilleById(int id);

	public Ville findVilleByName(String name);
	
	public List<Ville> findAllVille();

}