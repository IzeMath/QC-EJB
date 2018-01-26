package questionsServices;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return null;
	}

	@Override
	public void createQuestionSimple(final QuestionSimple quest) {
		em.persist(quest);		
	}

}
