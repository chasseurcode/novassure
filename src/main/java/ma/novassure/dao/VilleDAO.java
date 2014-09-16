package ma.novassure.dao;

import ma.novassure.domaine.Ville;

/**
 * 
 */
public interface VilleDAO {

	public void addVille(Ville ville);

	public void updateVille(Ville ville);

	public Ville findVilleById(int id);

	public Ville findVilleByName(String name);

}