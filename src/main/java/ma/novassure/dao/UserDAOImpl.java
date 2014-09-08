package ma.novassure.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.novassure.domaine.User;
import ma.novassure.utils.HibernateUtil;

public class UserDAOImpl implements UserDAO{
	SessionFactory sessionFactory;
	
	public UserDAOImpl() {
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	
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
		Session session=sessionFactory.openSession();
		User user=(User) session.createQuery("from User where username=?")
				.setString(0, username).list().get(0);
		return user;
	}

	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
