package ma.novassure.dao;

import java.util.List;

import ma.novassure.domaine.TypeQuittance;

/**
 * 
 */
public interface TypeQuittanceDAO {

    public TypeQuittance addTypeQuittance(TypeQuittance typeQuittance);

    public void updateTypeQuittance(TypeQuittance typeQuittance);

    public TypeQuittance findTypeQuittanceByLibelle(String libelle);

    public TypeQuittance findTypeQuittanceById(int id);
    
    public List<TypeQuittance> findAllTypes();

}