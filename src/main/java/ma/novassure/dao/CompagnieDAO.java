package ma.novassure.dao;

import java.util.List;

import ma.novassure.domaine.Compagnie;

/**
 * 
 */
public interface CompagnieDAO {

    public Compagnie addCompagnie(Compagnie compagnie);

    public void updateCompagnie(Compagnie compagnie);

    public Compagnie findCompagnieById(int id);

    public Compagnie findCompagnieByName(String name);
    
    public List<Compagnie> findAllCompagnies();
    
}