package ma.novassure.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ma.novassure.dao.UserDAO;
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

	public void desableUser(int id) {
		Session session=sessionFactory.openSession();
		User user=(User) session.load(User.class, id);
		user.setEnabled(false);
		session.flush();		
	}

	public void enableUser(int id) {
		Session session=sessionFactory.openSession();
		User user=(User) session.load(User.class, id);
		user.setEnabled(true);
		session.flush();
	}

	public void updateUser(User user) {
		Session session=sessionFactory.openSession();
		session.update(user);
		session.getTransaction().commit();
		session.close();
	}

	public User findUserByUsername(String username) {
		Session session=sessionFactory.openSession();
		User user=(User) session.createQuery("from User where username=?")
				.setString(0, username).uniqueResult();
		return user;
	}

	public User findUserByEmail(String email) {
		Session session=sessionFactory.openSession();
		User user=(User) session.createQuery("from User where email=?")
				.setString(0, email).list().get(0);
		return user;
	}

}
