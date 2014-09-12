package ma.novassure.dao;

import ma.novassure.domaine.Branche;

/**
 * 
 */
public interface BrancheDAO {


    /**
     * @param branche
     */
    public void addBranche(Branche branche);

    /**
     * @param branche
     */
    public void updateBranche(Branche branche);

    /**
     * @param id 
     * @return
     */
    public Branche findBrancheById(int id);

}