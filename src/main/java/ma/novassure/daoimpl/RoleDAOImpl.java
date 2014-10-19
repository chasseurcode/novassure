package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.RoleDAO;
import ma.novassure.domaine.Role;

import org.hibernate.Session;

public class RoleDAOImpl implements RoleDAO {
	private Session session;
	public RoleDAOImpl(Session session) {
		this.session=session;
	}
	
	public void addRole(Role role) {
		session.beginTransaction();
		session.save(role);
		session.getTransaction().commit();
		session.close();
	}

	public void removeRole(Role role) {
		// TODO Auto-generated method stub
		
	}

	public Role getRoleByName() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Role> findAllRoles() {
		return session.createQuery("From Role").list();
	}

	public Role findRoleById(int id) {
		return (Role) session.get(Role.class, id);
	}
	
}
