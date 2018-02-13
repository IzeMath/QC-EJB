package questionServices;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.quizcon.Question;
import org.quizcon.QuestionParameters;

/**
 * Session Bean implementation class QuestionsServices
 */
@Stateless
public class QuestionServices implements QuestionsServiceRemote {

	@PersistenceContext(unitName = "QC-JPA")
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public QuestionServices() {
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
	public void createQuestionSimple(final Question quest) {
		em.persist(quest);
	}

	@Override
	public List<String> getAllTheme() {
		final Query query = em.createNamedQuery("getAllThemes", String.class);
		return query.getResultList();
	}

	@Override
	public List<String> getAllDifficulties() {
		final Query query = em.createNamedQuery("getAllDifficulties", String.class);
		return query.getResultList();
	}

	@Override
	public Long getNbQuestionWithParameters(final QuestionParameters qp) {
		final Query query = em.createNamedQuery("getNbQuestionsInWhere", Long.class);
		query.setParameter("listDifficulties", qp.getArdf());
		query.setParameter("listThemes", qp.getArth());
		query.setParameter("listLangs", qp.getArlg());
		return (Long) query.getSingleResult();
	}

	@Override
	public List<String> getAllLangs() {
		final Query query = em.createNamedQuery("getAllLangs", String.class);
		return query.getResultList();
	}
	
	@Override
	public List<Question> getQuestionsWithParameters(final QuestionParameters qp) {
		final Query query = em.createNamedQuery("getQuestionsInWhere", Question.class);
		query.setMaxResults(qp.getNbQuestion());
		query.setParameter("listDifficulties", qp.getArdf());
		query.setParameter("listThemes", qp.getArth());
		query.setParameter("listLangs", qp.getArlg());
		// TODO Auto-generated method stub
		return query.getResultList();
	}

}
