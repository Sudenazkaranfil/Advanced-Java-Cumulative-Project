package quiz;
import java.util.List;

public class OpenEndedQuestion implements IQuestion<OpenEndedAnswer>{
    private final String prompt;
    private final int points;
    private final OpenEndedAnswer correctAnswer;

    public OpenEndedQuestion(String prompt, int points, String correctText) {
        this.prompt = prompt;
        this.points = points;
        this.correctAnswer = new OpenEndedAnswer(correctText);
    }

    @Override
    public String getPrompt() {
        return prompt;
    }
    @Override
    public int getPoints() {
        return points;
    }
    @Override
    public List<OpenEndedAnswer> getAnswers() {
        return List.of(correctAnswer);
    }
    @Override
    public boolean isCorrect(String userInput) {
        return correctAnswer.getText().equalsIgnoreCase(userInput.trim());
    }
    @Override
    public String toString() {
        return prompt;
    }
}
