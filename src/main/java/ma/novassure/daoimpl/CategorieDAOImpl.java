package ma.novassure.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.novassure.dao.CategorieDAO;
import ma.novassure.domaine.Categorie;
import ma.novassure.domaine.User;
import ma.novassure.utils.HibernateUtil;

/**
 * @author TARAM & BODIE
 */
public class CategorieDAOImpl implements CategorieDAO {
	SessionFactory sessionFactory;

	public CategorieDAOImpl() {
		sessionFactory=HibernateUtil.getSessionFactory();
	}

	public void addCategorie(Categorie categorie) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(categorie);
		session.getTransaction().commit();
		session.close();
	}

	public void updateCategorie(Categorie categorie) {
		Session session=sessionFactory.openSession();
		session.update(categorie);
		session.getTransaction().commit();
		session.close();
	}

	public Categorie findCategorieById(int id) {
		Session session=sessionFactory.openSession();
		Categorie categorie=(Categorie) session.createQuery("from Categorie where id=?")
				.setInteger(0, id).uniqueResult();
		return categorie;
	}

	public Categorie findCategorieByName(String libelle) {
		Session session=sessionFactory.openSession();
		Categorie categorie=(Categorie) session.createQuery("from Categorie where lebelle=?")
				.setString(0, libelle).uniqueResult();
		return categorie;
	}

	public Categorie findCategorieByCode(int code) {
		Session session=sessionFactory.openSession();
		Categorie categorie=(Categorie) session.createQuery("from Categorie where code=?")
				.setInteger(0, code).uniqueResult();
		return categorie;
	}

}