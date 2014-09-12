package ma.novassure.dao;

import ma.novassure.domaine.TypeQuittance;

/**
 * 
 */
public interface TypeQuittanceDAO {


    /**
     * @param typeQuittance
     */
    public void addTypeQuittance(TypeQuittance typeQuittance);

    /**
     * @param typeQuittance
     */
    public void updateTypeQuittance(TypeQuittance typeQuittance);

    /**
     * @param libelle 
     * @return
     */
    public TypeQuittance findTypeQuittanceByLibelle(String libelle);

    /**
     * @param id 
     * @return
     */
    public TypeQuittance findTypeQuittanceById(int id);

}