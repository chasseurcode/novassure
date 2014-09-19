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
		return typeQuittance;
	}

	public void updateTypeQuittance(TypeQuittance typeQuittance) {
		
	}

	public TypeQuittance findTypeQuittanceByLibelle(String libelle) {
		return null;
	}

	public TypeQuittance findTypeQuittanceById(int id) {
		return null;
	}

	public List<TypeQuittance> findAllTypes() {
				return null;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}