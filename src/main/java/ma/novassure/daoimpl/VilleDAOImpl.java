package ma.novassure.daoimpl;

import ma.novassure.dao.VilleDAO;
import ma.novassure.domaine.Ville;
import ma.novassure.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author TARAM & BODIE
 */
public class VilleDAOImpl implements VilleDAO {
	SessionFactory sessionFactory;

	public VilleDAOImpl() {
		sessionFactory=HibernateUtil.getSessionFactory();
	}

	public void addVille(Ville ville) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(ville);
		session.getTransaction().commit();
		session.close();		
	}

	public void updateVille(Ville ville) {
		Session session=sessionFactory.openSession();
		session.update(ville);
		session.getTransaction().commit();
		session.close();		
	}

	public Ville findVilleById(int id) {
		Session session=sessionFactory.openSession();
		Ville ville=(Ville) session.createQuery("from Ville where id=?")
				.setInteger(0, id).uniqueResult();
		return ville;		
	}

	public Ville findVilleByName(String name) {
		Session session=sessionFactory.openSession();
		Ville ville=(Ville) session.createQuery("from Ville where nom=?")
				.setString(0, name).uniqueResult();
		return ville;
	}

}