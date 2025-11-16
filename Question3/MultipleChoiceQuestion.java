package quiz;

import java.util.List;

public class MultipleChoiceQuestion implements IQuestion<MultipleChoiceAnswer>
{
    private final String prompt;
    private final int points;
    private final List<MultipleChoiceAnswer> options;

    public MultipleChoiceQuestion(String prompt, int points, List<MultipleChoiceAnswer> options) {
        this.prompt = prompt;
        this.points = points;
        this.options = List.copyOf(options);
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
    public List<MultipleChoiceAnswer> getAnswers() {
        return options;
    }
    @Override
    public boolean isCorrect(String userInput) {
        int index = userInput.toUpperCase().charAt(0) - 'A';
        return options.get(index).isCorrect();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder((prompt + "\n"));
        for(int i=0; i<options.size(); i++) {
            sb.append((char)('A' + i)).append(". ")
                    .append(options.get(i).getText()).append("\n");
        }
        return sb.toString();
    }
}
