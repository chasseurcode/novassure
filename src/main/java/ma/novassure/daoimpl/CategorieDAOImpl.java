package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.CategorieDAO;
import ma.novassure.domaine.Categorie;

import org.hibernate.Session;

/**
 * @author TARAM & BODIE
 */
public class CategorieDAOImpl implements CategorieDAO {
	private Session session;

	public CategorieDAOImpl(Session session) {
		this.session=session;
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
		return (Categorie) session.get(Categorie.class, id);
	}

	public Categorie findCategorieByName(String libelle) {
		Categorie categorie=(Categorie) session.createQuery("from Categorie where libelle= :lib")
				.setString("lib", libelle).uniqueResult();
		return categorie;
	}

	public Categorie findCategorieByCode(String code) {
		Categorie categorie=(Categorie) session.createQuery("from Categorie where code= :code")
				.setString("code", code).uniqueResult();
		return categorie;
	}

	@SuppressWarnings("unchecked")
	public List<Categorie> findAllCategories() {
		return session.createQuery("From Categorie").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}