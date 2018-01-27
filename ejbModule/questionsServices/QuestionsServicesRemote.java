package questionsServices;

import java.util.List;

import javax.ejb.Remote;

import org.quizcon.Question;
import org.quizcon.QuestionSimple;

@Remote
public interface QuestionsServicesRemote {
	
	public Question getRandQuestion();
	public void createQuestionSimple(QuestionSimple quest);
	public List<String> getAllTheme();
	public List<String> getAllDifficulties();
	public Long getNbQuestionWithParameters(List<String> listThemes, List<String> listDifficulties);

}
