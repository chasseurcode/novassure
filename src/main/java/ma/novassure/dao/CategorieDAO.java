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
	 * @param code 
	 * @return
	 */
	public Categorie findCategorieByCode(int code);

	/**
	 * @param libelle 
	 * @return
	 */
	public Categorie findCategorieByName(String libelle);

}