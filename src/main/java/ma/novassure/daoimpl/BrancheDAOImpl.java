package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.BrancheDAO;
import ma.novassure.domaine.Branche;
import ma.novassure.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author TARAM & BODIE
 */
public class BrancheDAOImpl implements BrancheDAO {
	SessionFactory sessionFactory;
	Session session;

	
    public BrancheDAOImpl() {
		sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();

    }

	public Branche addBranche(Branche branche) {
		session.beginTransaction();
		session.save(branche);
		session.getTransaction().commit();
		return branche;
	}

	public void updateBranche(Branche branche) {
		session.beginTransaction();
		session.update(branche);
		session.getTransaction().commit();
	}

	public Branche findBrancheById(int id) {
		Branche branche= (Branche) session.createQuery("from Branche where id=?")
				.setInteger(0, id).uniqueResult();
		return branche;
	}

	@SuppressWarnings("unchecked")
	public List<Branche> findAllBranches() {
		return session.createQuery("From Branche").list();
	}

}