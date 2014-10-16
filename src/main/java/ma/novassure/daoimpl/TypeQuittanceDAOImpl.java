package ma.novassure.daoimpl;

import java.util.List;

import org.hibernate.Session;

import ma.novassure.dao.TypeQuittanceDAO;
import ma.novassure.domaine.TypeQuittance;

/**
 * @author TARAM & BODIE
 */
public class TypeQuittanceDAOImpl implements TypeQuittanceDAO {

    private Session session;
    public TypeQuittanceDAOImpl(Session session) {
    	this.session=session;
    }

	public TypeQuittance addTypeQuittance(TypeQuittance typeQuittance) {
		session.beginTransaction();
		session.save(typeQuittance);
		session.getTransaction().commit();
		return typeQuittance;
	}

	public void updateTypeQuittance(TypeQuittance typeQuittance) {
		session.beginTransaction();
		session.update(typeQuittance);
		session.flush();
		session.getTransaction().commit();
	}

	public TypeQuittance findTypeQuittanceByLibelle(String libelle) {
		return (TypeQuittance) session.createQuery("From TypeQuittance where libelle= :lib")
				.setString("lib", libelle)
				.uniqueResult();
	}

	public TypeQuittance findTypeQuittanceById(int id) {
		return (TypeQuittance) session.get(TypeQuittance.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<TypeQuittance> findAllTypes() {
				return session.createQuery("From TypeQuittance").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<TypeQuittance> findAllEnabledTypes() {
		return session.createQuery("From TypeQuittance where deleted = :stat").setBoolean("stat", false).list();
	}

}