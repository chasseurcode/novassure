package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.CompagnieDAO;
import ma.novassure.domaine.Compagnie;

import org.hibernate.Session;

/**
 * @author TARAM & BODIE
 */
public class CompagnieDAOImpl implements CompagnieDAO {

    private Session session;
    
    public CompagnieDAOImpl(Session session) {
    	this.session=session;
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
		session.getTransaction().commit();
	}

	public Compagnie findCompagnieById(int id) {
		return (Compagnie) session.get(Compagnie.class, id);
	}

	public Compagnie findCompagnieByName(String name) {
		Compagnie comp=(Compagnie) session.createQuery("From Compagnie where nom= :name")
				.setString("name", name).uniqueResult();
		return comp;
	}

	@SuppressWarnings("unchecked")
	public List<Compagnie> findAllCompagnies() {

		return session.createQuery("From Compagnie").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}