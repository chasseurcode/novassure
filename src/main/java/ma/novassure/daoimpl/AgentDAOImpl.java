package ma.novassure.daoimpl;

import java.util.List;

import ma.novassure.dao.AgentDAO;
import ma.novassure.domaine.Agent;

import org.hibernate.Session;

/**
 * @author TARAM & BODIE
 */
public class AgentDAOImpl implements AgentDAO {
	private Session session;
	public AgentDAOImpl() {
	}
	
	public AgentDAOImpl(Session session) {
		this.session=session;
	}

	public Agent addAgent(Agent agent) {
		session.beginTransaction();
		session.save(agent);
		session.getTransaction().commit(); 
		return agent;
	}

	public void updateAgent(Agent agent) {
		session.beginTransaction();
		session.update(agent);
		session.getTransaction().commit();		
	}
	public Agent findAgentById(int id) {
		return (Agent) session.get(Agent.class, id);
	}

	public Agent findAgentByCode(String code) {
		Agent agent=(Agent) session.createQuery("from Agent where code= :code")
				.setString("code", code).uniqueResult();
		return agent;
	}

	public Agent findAgentByName(String name) {
		Agent agent=(Agent) session.createQuery("from Agent where nom= :name")
				.setString("name", name).uniqueResult();
		return agent;
	}

	@SuppressWarnings("unchecked")
	public List<Agent> findAllAgents() {
		return session.createQuery("From Agent").list();
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	public List<Agent> findAllEnabledAgents() {
		return session.createQuery("From Agent where enabled= :status").setBoolean("status",true).list();
	}

}