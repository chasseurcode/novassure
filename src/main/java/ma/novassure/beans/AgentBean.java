package ma.novassure.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import ma.novassure.domaine.Agent;

@ManagedBean
@RequestScoped
public class AgentBean {
	private Agent agent;
	public AgentBean() {
		System.out.println("creeer");
	}
	public String addAgent() {
		System.out.println(agent.getCode());
		return "";
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
}
