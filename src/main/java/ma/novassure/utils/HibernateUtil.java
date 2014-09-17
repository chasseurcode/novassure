package ma.novassure.utils;

import ma.novassure.domaine.Affaire;
import ma.novassure.domaine.Agent;
import ma.novassure.domaine.Branche;
import ma.novassure.domaine.Categorie;
import ma.novassure.domaine.Client;
import ma.novassure.domaine.Compagnie;
import ma.novassure.domaine.Document;
import ma.novassure.domaine.Garantie;
import ma.novassure.domaine.LigneGarantie;
import ma.novassure.domaine.Paiement;
import ma.novassure.domaine.Quittance;
import ma.novassure.domaine.Role;
import ma.novassure.domaine.TypeQuittance;
import ma.novassure.domaine.User;
import ma.novassure.domaine.Ville;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


@SuppressWarnings("deprecation")
public class HibernateUtil {

	  private static HibernateUtil instance = null;
		private static SessionFactory sessionFactory;
		private static ServiceRegistry serviceRegistry;
	 
		private HibernateUtil() {
		}
		
		static {
			try {
				Configuration configuration = new Configuration().configure();
				
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Role.class);
				configuration.addAnnotatedClass(Agent.class);
				configuration.addAnnotatedClass(Quittance.class);
				configuration.addAnnotatedClass(Affaire.class);
				configuration.addAnnotatedClass(Compagnie.class);
				configuration.addAnnotatedClass(TypeQuittance.class);
				configuration.addAnnotatedClass(Ville.class);
				configuration.addAnnotatedClass(Branche.class);
				configuration.addAnnotatedClass(Categorie.class);
				configuration.addAnnotatedClass(Garantie.class);
				configuration.addAnnotatedClass(Paiement.class);
				configuration.addAnnotatedClass(Document.class);
				configuration.addAnnotatedClass(LigneGarantie.class);
				configuration.addAnnotatedClass(Client.class);

				
				serviceRegistry = new ServiceRegistryBuilder()
										.applySettings(configuration.getProperties())
										.buildServiceRegistry();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (HibernateException he) {
				System.err.println("Erreur hibernate: " + he);
				throw new ExceptionInInitializerError(he);
			}
		}
	 
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		
		public Session getSession(){
			return getSessionFactory().openSession();
		}
	 
		
		public static HibernateUtil getInstance(){
	        if(instance == null){
	            instance = new HibernateUtil();
	        }
	        return instance;
	    }
		
		public static void testConnection() throws Exception {
			getSessionFactory().openSession();
		}
}
