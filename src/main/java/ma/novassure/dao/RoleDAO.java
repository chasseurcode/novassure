package ma.novassure.dao;

import ma.novassure.domaine.Role;

public interface RoleDAO {
	public void addRole(Role role);
	public void removeRole(Role role);
	public Role getRoleByName();
}
