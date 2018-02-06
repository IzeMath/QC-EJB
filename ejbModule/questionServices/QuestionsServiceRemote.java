package questionServices;

import java.util.List;

import javax.ejb.Remote;

import org.quizcon.Question;
import org.quizcon.QuestionParameters;

@Remote
public interface QuestionsServiceRemote {
	
	public Question getRandQuestion();
	public List<Question> getQuestionsWithParameters(QuestionParameters qp);
	public void createQuestionSimple(Question quest);
	public List<String> getAllTheme();
	public List<String> getAllDifficulties();
	public List<String> getAllLangs();
	public Long getNbQuestionWithParameters(QuestionParameters qp);

}
