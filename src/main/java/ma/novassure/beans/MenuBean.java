package ma.novassure.beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class MenuBean {
	
	public String getsionUtilisateur() {
		System.out.println("coucou");
		return "pretty:user";
	}
}
