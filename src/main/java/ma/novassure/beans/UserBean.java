package ma.novassure.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ma.novassure.security.UserDetailService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@ManagedBean
@RequestScoped
public class UserBean {
	private String username;
	private String password;
	private UserDetailService userDetailService;
	
	public UserBean() {
		userDetailService=new UserDetailService();
	}
	
	public String login() {
		System.out.println(username+""+password);
		try {
			UserDetails userDetails=userDetailService.loadUserByUsername(username);
			Authentication auth=new UsernamePasswordAuthenticationToken(userDetails, 
							userDetails.getPassword(), userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
			System.out.println("connecte");
		} catch (UsernameNotFoundException e) {
			System.out.println("Utilisateur inexistant");
		}
		
		return "index.xhtml";
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
	
}
