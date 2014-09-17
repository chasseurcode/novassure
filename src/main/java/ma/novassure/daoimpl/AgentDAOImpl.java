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

	public AgentDAOImpl() {
		sessionFactory=HibernateUtil.getSessionFactory();
		
	}

	public void addAgent(Agent agent) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(agent);
		session.getTransaction().commit();
		session.close();		
	}

	public void updateAgent(Agent agent) {
		Session session=sessionFactory.openSession();
		session.update(agent);
		session.getTransaction().commit();
		session.close();		
	}
	public Agent findAgentById(int id) {
		Session session=sessionFactory.openSession();
		Agent agent=(Agent) session.createQuery("from Agent where id=?")
				.setInteger(0, id).uniqueResult();
		return agent;
	}

	public Agent findAgentByCode(String code) {
		Session session=sessionFactory.openSession();
		Agent agent=(Agent) session.createQuery("from Agent where code=?")
				.setString(0, code).uniqueResult();
		return agent;
	}

	public Agent findAgentByName(String name) {
		Session session=sessionFactory.openSession();
		Agent agent=(Agent) session.createQuery("from Agent where nom=?")
				.setString(0, name).uniqueResult();
		return agent;
	}



}