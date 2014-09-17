package ma.novassure.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.novassure.dao.BrancheDAO;
import ma.novassure.domaine.Branche;
import ma.novassure.utils.HibernateUtil;

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

	public void addBranche(Branche branche) {
		session.beginTransaction();
		session.save(branche);
		session.getTransaction().commit();
		session.close();
	}

	public void updateBranche(Branche branche) {
		session.update(branche);
		session.getTransaction().commit();
		session.close();		
	}

	public Branche findBrancheById(int id) {
		Branche branche= (Branche) session.createQuery("from Branche where id=?")
				.setInteger(0, id).uniqueResult();
		return branche;
	}

}