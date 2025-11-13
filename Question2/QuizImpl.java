package quiz;

import java.util.ArrayList;
import java.util.List;

public class QuizImpl implements IQuiz {
    private List<IQuestion> questions = new ArrayList<>();

     @Override
    public void addQuestion(IQuestion q) {
        questions.add(q);
    }

    @Override
    public List<IQuestion> getQuestions() {
        return List.copyOf(questions);
    }

    @Override
    public int evaluate(List<String> answers) {
        int score = 0;

        for(int i=0; i<answers.size(); i++) {
            IQuestion question = questions.get(i);
            String userAnswer = answers.get(i);

            if(question.isCorrect(userAnswer)) {
                score += question.getPoints();
            }
        }
        return score;
    }
}
