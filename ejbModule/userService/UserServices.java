package userService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.user.Utilisateur;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
@LocalBean
public class UserServices implements UserServicesRemote {
	@PersistenceContext(unitName = "QC-JPA") // Remplace le entity manager factory
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public UserServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Utilisateur login(final String email, final String password) {
		final Query query = em.createNamedQuery("UtilisateurFindByLogin", Utilisateur.class);
		query.setParameter("email", email);
		query.setParameter("password", password);
		final Utilisateur usr = (Utilisateur) query.getSingleResult();
		return usr;

	}

	@Override
	public void createUser(final String name, final String fname, final String username, final String email, final String password) {
		final Utilisateur user = new Utilisateur(name, fname, username, email, password);
		em.persist(user);

	}

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "TEST";
	}

}