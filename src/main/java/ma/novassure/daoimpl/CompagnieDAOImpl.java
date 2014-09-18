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
		return null;
	}

	public void updateCompagnie(Compagnie compagnie) {
		
	}

	public Compagnie findCompagnieById(int id) {
		return null;
	}

	public Compagnie findCompagnieByName(String name) {
		
		return null;
	}

	public List<Compagnie> findAllCompagnies() {

		return null;
	}

}