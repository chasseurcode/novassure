package ma.novassure.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ma.novassure.dao.RoleDAO;
import ma.novassure.daoimpl.RoleDAOImpl;
import ma.novassure.daoimpl.UserDAOImpl;
import ma.novassure.domaine.Role;
import ma.novassure.domaine.User;

@ManagedBean
@SessionScoped
public class UserBean {
	private UserDAOImpl userDAO;
	private List<User> users;
	private String username;
	private String password;
	private String findName;
	private User currentUser;
	private String[] selectedRole;
	private List<Role> roles;
	private RoleDAO roleDAO;

	public UserBean() {
		userDAO=new UserDAOImpl();
		roleDAO=new RoleDAOImpl(userDAO.getSession());
		users=userDAO.getAll();
		System.out.println(users.size());
		currentUser=new User();
		setRoles(roleDAO.findAllRoles());
	}

	public String login() {
		return null;
	}

	public void load(){
		currentUser=userDAO.findUserByUsername(findName);
	}

	public void createUser() {
		for(int i=0;i<selectedRole.length;i++){
			Role role=roleDAO.findRoleById(Integer.parseInt(selectedRole[i]));
			currentUser.addRole(role);
		}
		userDAO.addUser(currentUser);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getFindName() {
		return findName;
	}

	public void setFindName(String findName) {
		this.findName = findName;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String[] getSelectedRole() {
		return selectedRole;
	}

	public void setSelectedRole(String[] selectedRole) {
		this.selectedRole = selectedRole;
	}
	
	public void desableUser(User user) {
		user.setEnabled(false);
		userDAO.updateUser(user);
		refreshList();
		System.out.println("desenabled");
	}

	public void enableUser(User user) {
		user.setEnabled(true);
		userDAO.updateUser(user);
		refreshList();
		System.out.println("enabled");
	}

	private void refreshList() {
		setUsers(userDAO.getAll());
	}
}
