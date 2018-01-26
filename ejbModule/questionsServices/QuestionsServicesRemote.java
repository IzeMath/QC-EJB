package questionsServices;

import javax.ejb.Remote;

import org.quizcon.Question;
import org.quizcon.QuestionSimple;

@Remote
public interface QuestionsServicesRemote {
	
	public Question getRandQuestion();
	public void createQuestionSimple(QuestionSimple quest);

}
