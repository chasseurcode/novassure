package ma.novassure.daoimpl;

import ma.novassure.dao.CategorieDAO;
import ma.novassure.domaine.Categorie;
import ma.novassure.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author TARAM & BODIE
 */
public class CategorieDAOImpl implements CategorieDAO {
	SessionFactory sessionFactory;
	Session session;


	public CategorieDAOImpl() {
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
	}

	public void addCategorie(Categorie categorie) {
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
		session.close();
	}

	public void updateCategorie(Categorie categorie) {
		session.beginTransaction();
		session.update(categorie);
		session.getTransaction().commit();
		session.close();
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

	public Categorie findCategorieByCode(int code) {
		Categorie categorie=(Categorie) session.createQuery("from Categorie where code=?")
				.setInteger(0, code).uniqueResult();
		return categorie;
	}

}