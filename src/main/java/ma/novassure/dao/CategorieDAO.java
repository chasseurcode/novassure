package ma.novassure.dao;

import java.util.List;

import ma.novassure.domaine.Categorie;

/**
 * 
 */
public interface CategorieDAO {

	public Categorie addCategorie(Categorie categorie);

	public void updateCategorie(Categorie categorie);

	public Categorie findCategorieById(int id);

	public Categorie findCategorieByCode(String code);

	public Categorie findCategorieByName(String libelle);
	
	public List<Categorie> findAllCategories();
	

}