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
		return (User) session.createQuery("from User where username=:username")
				.setString("username", username)
				.uniqueResult();
	}

	public User findUserByEmail(String email) {
		return (User) session.createQuery("from User where email= :mail")
				.setString("mail", email).uniqueResult(); 
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		return session.createQuery("From User").list();
	}

}
