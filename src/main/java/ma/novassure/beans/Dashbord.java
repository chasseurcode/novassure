package ma.novassure.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
@ManagedBean
@ApplicationScoped
public class Dashbord {
	private DashboardModel model;
	
	@PostConstruct
	public void initialiser() {
		model=new DefaultDashboardModel();
		DashboardColumn colonne1=new DefaultDashboardColumn();
		DashboardColumn colonne2=new DefaultDashboardColumn();
		
		colonne1.addWidget("stat");
		colonne1.addWidget("echeance");
		
		colonne2.addWidget("tbl_bord");
		colonne2.addWidget("derniere");
		colonne2.addWidget("attente");
		
		model.addColumn(colonne1);
		model.addColumn(colonne2);
	}

	public DashboardModel getModel() {
		return model;
	}

	public void setModel(DashboardModel model) {
		this.model = model;
	}
	
	
}
