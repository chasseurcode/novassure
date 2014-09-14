package ma.novassure.security;

import java.util.ArrayList;
import java.util.List;

import ma.novassure.dao.UserDAO;
import ma.novassure.daoimpl.UserDAOImpl;
import ma.novassure.domaine.Role;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailService implements UserDetailsService {
	UserDAO userDAO;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		userDAO=new UserDAOImpl();
		ma.novassure.domaine.User user=userDAO.findUserByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException(null);
		} else {
			List<GrantedAuthority> authorities=builAuthorities(user.getRoles());
			return buildUserForAuthentication(user, authorities);
		}	
	}
	
	public User buildUserForAuthentication(ma.novassure.domaine.User user,List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}
	
	private List<GrantedAuthority> builAuthorities(List<Role> roles) {
		 List<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
		 for (Role role: roles) {
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		 return new ArrayList<GrantedAuthority>(auths);
	}
}
