package ma.novassure.dao;

import java.util.List;

import ma.novassure.domaine.Branche;

/**
 * 
 */
public interface BrancheDAO {


    /**
     * @param branche
     */
    public Branche addBranche(Branche branche);

    /**
     * @param branche
     */
    public void updateBranche(Branche branche);

    /**
     * @param id 
     * @return
     */
    public Branche findBrancheById(int id);

    public List<Branche> findAllBranches();
}