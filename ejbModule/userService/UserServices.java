package userService;

import java.util.Hashtable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.user.Statistique;
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
	public void createUser(final String username, final String email, final String password) {
		final Utilisateur user = new Utilisateur(username, email, password);
		em.persist(user);

	}

	@Override
	public Hashtable<String, Float> getStats(final Utilisateur user) {
		final Hashtable<String, Float> htStats = new Hashtable<>();
		final Utilisateur usrData = em.find(Utilisateur.class, user.getId());
		float nbQuestionT = 0;
		float nbReponseT = 0;
		
		for (final Statistique st : usrData.getlStat()) {
			final float nbRep =  st.getNbReponse();
			final float nbQuest = st.getNbQuestions();
			htStats.put(st.getTheme(), (nbRep / nbQuest) * 100);
			nbQuestionT += nbQuest;
			nbReponseT += nbRep;
		}
		htStats.put("Total", (nbReponseT / nbQuestionT) *100 );
		
		
		return htStats;
	}

	@Override
	public void createUser(final String username, final String email, final String password, final List<Statistique> lStat) {
		final Utilisateur user = new Utilisateur(username, email, password);
		user.setlStat(lStat);
		em.persist(user);
		
	}

}
