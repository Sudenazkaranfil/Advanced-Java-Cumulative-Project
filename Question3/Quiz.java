package quiz;
import java.util.ArrayList;
import java.util.List;

public class Quiz <T extends IQuestion<?>> {
    private final List<T> questions = new ArrayList<>();

    public void addQuestion(T q) {
        questions.add(q);
    }
    public List<T> getQuestions() {
        return List.copyOf(questions);
    }

    public int evaluate(List<String> answers) {
        int total = 0;

        for(int i=0; i<answers.size(); i++) {
            T question = questions.get(i);
            if(question.isCorrect(answers.get(i))) {
                total += question.getPoints();
            }
        }
        return total;
    }
}
