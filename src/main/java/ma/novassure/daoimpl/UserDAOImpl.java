package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.UserDAO;
import ma.novassure.domaine.User;
import ma.novassure.utils.HibernateUtil;

import org.hibernate.Session;

public class UserDAOImpl implements UserDAO{
	Session session;
	
	public UserDAOImpl() {
		session=HibernateUtil.getSession();
	}
	
	public void addUser(User user) {
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	public void desableUser(int id) {
		User user=(User) session.load(User.class, id);
		user.setEnabled(false);
		session.flush();		
	}

	public void enableUser(int id) {
		User user=(User) session.load(User.class, id);
		user.setEnabled(true);
		session.flush();
	}

	public void updateUser(User user) {
		session.update(user);
		session.getTransaction().commit();
	}

	public User findUserByUsername(String username) {
		User user=(User) session.createQuery("from User where username=?")
				.setString(0, username).uniqueResult();
		return user;
	}

	public User findUserByEmail(String email) {
		User user=(User) session.createQuery("from User where email=?")
				.setString(0, email).list().get(0);
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return session.createQuery("From User").list();
	}

}
