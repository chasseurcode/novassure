package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.BrancheDAO;
import ma.novassure.domaine.Branche;

import org.hibernate.Session;

/**
 * @author TARAM & BODIE
 */
public class BrancheDAOImpl implements BrancheDAO {
private	Session session;

    public BrancheDAOImpl(Session session) {
		this.session=session;

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
		return (Branche) session.get(Branche.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Branche> findAllBranches() {
		return session.createQuery("From Branche").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Branche> findAllActivedBranches() {
		return session.createQuery("From Branche where activated= :stat").setBoolean("stat", true).list();
	}

}