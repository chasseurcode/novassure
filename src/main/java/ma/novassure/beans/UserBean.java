package ma.novassure.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ma.novassure.dao.UserDAO;
import ma.novassure.daoimpl.UserDAOImpl;
import ma.novassure.domaine.User;

@ManagedBean
@RequestScoped
public class UserBean {
	UserDAO userDAO;
	List<User> users;
	private String username;
	private String password;
	private String findName;
	private User currentUser;
	
	public UserBean() {
		userDAO=new UserDAOImpl();
		users=userDAO.getAll();
	}
	
	public String login() {
		return null;
	}
	
	public void load(){
		System.out.println(findName);
		currentUser=userDAO.findUserByUsername(findName);
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

	
}
