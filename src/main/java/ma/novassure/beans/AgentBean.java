package ma.novassure.beans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import ma.novassure.dao.AgentDAO;
import ma.novassure.daoimpl.AgentDAOImpl;
import ma.novassure.domaine.Agent;
import ma.novassure.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class AgentBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Logger logger=Logger.getLogger(AgentBean.class.getName());
	private AgentDAO dao;
	private Agent agent;
	private List<Agent> agents;
	public AgentBean() {
		agent=new Agent();
		dao=new AgentDAOImpl(HibernateUtil.getSession());
		agents=dao.findAllEnabledAgents();
	}
	public void addAgent(ActionEvent event) {
		dao.addAgent(agent);
		agent=new Agent();
		agents=dao.findAllEnabledAgents();
		logger.info("ajout"+agent.getNom());
	}
	
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public List<Agent> getAgents() {
		return agents;
	}
	public void remove(Agent a) {
		a.setEnabled(false);
		dao.updateAgent(a);
		agents=dao.findAllEnabledAgents();
		logger.info("remove:"+a.getCode());
	}
	
	public void update() {
		dao.updateAgent(agent);
		agents=dao.findAllEnabledAgents();
		logger.info("update: "+agent.getCode());
	}
	
	public void load(Agent a) {
		setAgent(a);
	}
}
