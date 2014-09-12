package ma.novassure.dao;

import ma.novassure.domaine.Compagnie;

/**
 * 
 */
public interface CompagnieDAO {


    /**
     * @param compagnie
     */
    public void addCompagnie(Compagnie compagnie);

    /**
     * @param compagnie
     */
    public void updateCompagnie(Compagnie compagnie);

    /**
     * @param id
     */
    public void findCompagnieById(int id);

    /**
     * @param name
     */
    public void findCompagnieByName(String name);

}