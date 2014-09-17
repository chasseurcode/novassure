package ma.novassure.daoimpl;

import ma.novassure.dao.AgentDAO;
import ma.novassure.domaine.Agent;
import ma.novassure.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author TARAM & BODIE
 */
public class AgentDAOImpl implements AgentDAO {
	SessionFactory sessionFactory;
	Session session;


	public AgentDAOImpl() {
		sessionFactory=HibernateUtil.getSessionFactory();
	     session=sessionFactory.openSession();	
	}

	public void addAgent(Agent agent) {
		session.beginTransaction();
		session.save(agent);
		session.getTransaction().commit();
		session.close();		
	}

	public void updateAgent(Agent agent) {
		session.beginTransaction();
		session.update(agent);
		session.getTransaction().commit();
		session.close();		
	}
	public Agent findAgentById(int id) {
		Agent agent=(Agent) session.createQuery("from Agent where id=?")
				.setInteger(0, id).uniqueResult();
		return agent;
	}

	public Agent findAgentByCode(String code) {
		Agent agent=(Agent) session.createQuery("from Agent where code=?")
				.setString(0, code).uniqueResult();
		return agent;
	}

	public Agent findAgentByName(String name) {
		Agent agent=(Agent) session.createQuery("from Agent where nom=?")
				.setString(0, name).uniqueResult();
		return agent;
	}



}