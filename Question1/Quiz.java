package quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private final List<Question> questions = new ArrayList<>();

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public List<Question> getQuestions() {
        return List.copyOf(questions);
    }

    public int evaluate(List<String> answers) {
        int total = 0;
        int n = Math.min(questions.size(), answers.size());

        for(int i=0; i<n; i++) {
            if(questions.get(i).isCorrect(answers.get(i))) {
                total+= questions.get(i).getPoints();
            }
        }
        return total;
    }
}
