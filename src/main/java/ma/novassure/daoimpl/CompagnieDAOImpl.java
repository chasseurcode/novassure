package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.CompagnieDAO;
import ma.novassure.domaine.Compagnie;
import ma.novassure.utils.HibernateUtil;

import org.hibernate.Session;

/**
 * @author TARAM & BODIE
 */
public class CompagnieDAOImpl implements CompagnieDAO {

    Session session;
    
    public CompagnieDAOImpl() {
    	session=HibernateUtil.getSession();
    }

	public Compagnie addCompagnie(Compagnie compagnie) {
		session.beginTransaction();
		session.save(compagnie);
		session.getTransaction().commit();
		return compagnie;
	}

	public void updateCompagnie(Compagnie compagnie) {
		session.beginTransaction();
		session.update(compagnie);
		session.flush();
	}

	public Compagnie findCompagnieById(int id) {
		return (Compagnie) session.get(Compagnie.class, id);
	}

	public Compagnie findCompagnieByName(String name) {
		Compagnie comp=(Compagnie) session.createQuery("From Compagnie where nom=?").setString(0, name).uniqueResult();
		return comp;
	}

	@SuppressWarnings("unchecked")
	public List<Compagnie> findAllCompagnies() {

		return session.createQuery("From Compagnie").list();
	}

}