package ma.novassure.dao;

import ma.novassure.domaine.Categorie;

/**
 * 
 */
public interface CategorieDAO {


    /**
     * @param categorie
     */
    public void addCategorie(Categorie categorie);

    /**
     * @param categorie
     */
    public void updateCategorie(Categorie categorie);

    /**
     * @param id 
     * @return
     */
    public Categorie findCategorieById(int id);

    /**
     * @param libelle 
     * @return
     */
    public Categorie findCategorieByName(String libelle);

}