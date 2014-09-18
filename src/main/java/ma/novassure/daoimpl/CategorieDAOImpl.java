package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.CategorieDAO;
import ma.novassure.domaine.Categorie;
import ma.novassure.utils.HibernateUtil;

import org.hibernate.Session;

/**
 * @author TARAM & BODIE
 */
public class CategorieDAOImpl implements CategorieDAO {
	Session session;


	public CategorieDAOImpl() {
		session=HibernateUtil.getSession();
	}

	public Categorie addCategorie(Categorie categorie) {
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
		return categorie;
	}

	public void updateCategorie(Categorie categorie) {
		session.beginTransaction();
		session.update(categorie);
		session.getTransaction().commit();
		}

	public Categorie findCategorieById(int id) {
		Categorie categorie=(Categorie) session.createQuery("from Categorie where id=?")
				.setInteger(0, id).uniqueResult();
		return categorie;
	}

	public Categorie findCategorieByName(String libelle) {
		Categorie categorie=(Categorie) session.createQuery("from Categorie where libelle=?")
				.setString(0, libelle).uniqueResult();
		return categorie;
	}

	public Categorie findCategorieByCode(String code) {
		Categorie categorie=(Categorie) session.createQuery("from Categorie where code=?")
				.setString(0, code).uniqueResult();
		return categorie;
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> findAllCategories() {
		return session.createQuery("From Categorie").list();
	}

}