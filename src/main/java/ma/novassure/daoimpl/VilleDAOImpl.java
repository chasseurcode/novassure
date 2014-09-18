package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.VilleDAO;
import ma.novassure.domaine.Ville;

import org.hibernate.Session;

/**
 * @author TARAM & BODIE
 */
public class VilleDAOImpl implements VilleDAO {
	Session session;


	public VilleDAOImpl(Session session) {
		this.session=session;

	}

	public Ville addVille(Ville ville) {
		session.beginTransaction();
		session.save(ville);
		session.getTransaction().commit();
		return ville;
	}

	public void updateVille(Ville ville) {
		session.beginTransaction();
		session.update(ville);
		session.getTransaction().commit();
	}

	public Ville findVilleById(int id) {
		return (Ville) session.get(Ville.class, id);		
	}

	public Ville findVilleByName(String name) {
		Ville ville=(Ville) session.createQuery("from Ville where nom=?")
				.setString(0, name).uniqueResult();
		return ville;
	}

	@SuppressWarnings("unchecked")
	public List<Ville> findAllVille() {
		return session.createQuery("From Ville").list();
	}

}