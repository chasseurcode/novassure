package ma.novassure.essai;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.novassure.dao.UserDAO;
import ma.novassure.dao.UserDAOImpl;
import ma.novassure.domaine.Role;
import ma.novassure.domaine.User;
@WebServlet(urlPatterns="/essai")
public class Essai extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserDAO userDAO=new UserDAOImpl();
		
		User user=new User();
		user.setUsername("taram");
		user.setPassword("assetou");
		user.setEmail("tsayoubaa@gmail.com");
		
		Role role1=new Role("USER");
		Role role2=new Role("ADMIN");
		
		
		user.getRoles().add(role1);
		user.getRoles().add(role2);
		
		userDAO.addUser(user);
		resp.getWriter().write("ok");
	}
}
