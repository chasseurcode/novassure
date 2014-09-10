package ma.novassure.dao;

import ma.novassure.domaine.User;

public interface UserDAO {
	public void addUser(User user);
	public void desableUser(int id);
	public void enableUser(int id);
	public void updateUser(User user);
	public User findUserByUsername(String username);
	public User findUserByEmail(String email);
}
