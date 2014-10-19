package ma.novassure.dao;

import java.util.List;

import ma.novassure.domaine.Role;

public interface RoleDAO {
	public void addRole(Role role);
	public void removeRole(Role role);
	public Role getRoleByName();
	public Role findRoleById(int id);
	public List<Role> findAllRoles();
}
