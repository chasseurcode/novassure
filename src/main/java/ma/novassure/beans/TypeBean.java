package ma.novassure.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ma.novassure.dao.TypeQuittanceDAO;
import ma.novassure.daoimpl.TypeQuittanceDAOImpl;
import ma.novassure.domaine.TypeQuittance;
import ma.novassure.utils.HibernateUtil;

@ManagedBean
@SessionScoped
public class TypeBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<TypeQuittance> typeQuittances;
	private TypeQuittanceDAO dao;
	private TypeQuittance typeQuittance;
	private TypeQuittance currentType;

	public TypeBean() {
		setDao(new TypeQuittanceDAOImpl(HibernateUtil.getSession()));
		refreshList();
	}

	private void refreshList() {
		setTypeQuittances(dao.findAllEnabledTypes());
		setTypeQuittance(new TypeQuittance());
	}

	public void addType() {
		if(typeQuittance!=null){
			System.out.println("added : "+typeQuittance.getLibelle());
			dao.addTypeQuittance(typeQuittance);
			refreshList();
		}
	}

	public void load(TypeQuittance type) {
		setCurrentType(type);
	}

	public void remove(TypeQuittance type) {
		type.setDeleted(true);
		dao.updateTypeQuittance(type);
		refreshList();
	}

	public void update() {
		dao.updateTypeQuittance(currentType);
		refreshList();
	}
	public List<TypeQuittance> getTypeQuittances() {
		return typeQuittances;
	}

	public void setTypeQuittances(List<TypeQuittance> typeQuittances) {
		this.typeQuittances = typeQuittances;
	}

	public TypeQuittanceDAO getDao() {
		return dao;
	}

	public void setDao(TypeQuittanceDAO dao) {
		this.dao = dao;
	}

	public TypeQuittance getTypeQuittance() {
		return typeQuittance;
	}

	public void setTypeQuittance(TypeQuittance typeQuittance) {
		this.typeQuittance = typeQuittance;
	}

	public TypeQuittance getCurrentType() {
		return currentType;
	}

	public void setCurrentType(TypeQuittance currentType) {
		this.currentType = currentType;
	}

}
