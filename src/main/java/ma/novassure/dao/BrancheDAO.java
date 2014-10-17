package ma.novassure.dao;

import java.util.List;

import ma.novassure.domaine.Branche;
import ma.novassure.domaine.Categorie;

/**
 * 
 */
public interface BrancheDAO {

    public Branche addBranche(Branche branche);
    
    public void updateBranche(Branche branche);
    
    public void updateCategorie(Categorie garantie);

    public Branche findBrancheById(int id);

    public List<Branche> findAllBranches();
    
    public List<Branche> findAllActivedBranches();
}