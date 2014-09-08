package ma.novassure.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.novassure.domaine.User;
import ma.novassure.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO{
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	public void addUser(User user) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}

	public void desableUser() {
		// TODO Auto-generated method stub
		
	}

	public void enableUser() {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
