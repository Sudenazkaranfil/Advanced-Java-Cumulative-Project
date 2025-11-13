package quiz;

import java.util.ArrayList;
import java.util.List;

public interface IQuiz {
    void addQuestion(IQuestion q);
    List<IQuestion> getQuestions();
    int evaluate(List<String> answers);
}
