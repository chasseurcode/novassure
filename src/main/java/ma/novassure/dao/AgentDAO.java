package ma.novassure.dao;

import ma.novassure.domaine.Agent;

/**
 * 
 */
public interface AgentDAO {


    /**
     * @param agent
     */
    public void addAgent(Agent agent);

    /**
     * @param agent
     */
    public void updateAgent(Agent agent);

    /**
     * @param code 
     * @return
     */
    public Agent findAgentByCode(String code);
    /**
     * @param id 
     * @return
     */
    public Agent findAgentById(int id);

    /**
     * @param name 
     * @return
     */
    public Agent findAgentByName(String name);
    
   


}