package questionsServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.quizcon.Question;
import org.quizcon.QuestionSimple;

/**
 * Session Bean implementation class QuestionsServices
 */
@Stateless
public class QuestionsServices implements QuestionsServicesRemote {

	@PersistenceContext(unitName = "QC-JPA")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public QuestionsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Question getRandQuestion() {
		final Query query = em.createNamedQuery("getRandomQuestion", Question.class);
		query.setMaxResults(1);
		final Question qst = (Question) query.getSingleResult();
		return qst;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * questionsServices.QuestionsServicesRemote#createQuestionSimple(org.quizcon.
	 * QuestionSimple)
	 */
	@Override
	public void createQuestionSimple(final QuestionSimple quest) {
		em.persist(quest);
	}

	@Override
	public List<String> getAllTheme() {
		final Query query = em.createNamedQuery("getAllTheme", String.class);
		return query.getResultList();
	}

	@Override
	public List<String> getAllDifficulties() {
		final Query query = em.createNamedQuery("getAllDifficulties", String.class);
		return query.getResultList();
	}

	@Override
	public Long getNbQuestionWithParameters(final List<String> listThemes, final List<String> listDifficulties) {
		final Query query = em.createNamedQuery("getNbQuestionInWhere", Long.class);
		query.setParameter("listDifficulties", listDifficulties);
		query.setParameter("listThemes", listThemes);
		return (Long) query.getSingleResult();
	}

}
