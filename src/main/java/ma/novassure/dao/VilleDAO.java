package ma.novassure.dao;

import ma.novassure.domaine.Ville;

/**
 * 
 */
public interface VilleDAO {


    /**
     * @param ville
     */
    public void addVille(Ville ville);

    /**
     * @param ville
     */
    public void updateVille(Ville ville);

    /**
     * @param id
     */
    public void findVilleById(int id);

    /**
     * @param name
     */
    public void findVilleByName(String name);

}