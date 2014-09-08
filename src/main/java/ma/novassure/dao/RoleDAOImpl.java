package ma.novassure.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.novassure.domaine.Role;
import ma.novassure.utils.HibernateUtil;

public class RoleDAOImpl implements RoleDAO {
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	
	public void addRole(Role role) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(role);
		session.getTransaction().commit();
		session.close();
	}

	public void removeRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	public Role getRoleByName() {
		// TODO Auto-generated method stub
		return null;
	}

}
