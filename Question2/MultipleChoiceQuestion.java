package quiz;

import java.util.List;
import java.util.stream.IntStream;

public class MultipleChoiceQuestion implements IQuestion{
    private final String prompt;
    private final int points;
    private final List<IAnswer> options;

    public MultipleChoiceQuestion(String prompt, int points, List<IAnswer> options) {
        this.prompt = prompt;
        this.points = points;
        this.options = options;
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
    public boolean isCorrect(String userAnswer) {
        int index = userAnswer.toUpperCase().charAt(0) - 'A'; // A->0, B->1, C->2
        if(index >= 0 && index < options.size()) {
            return options.get(index).isCorrect();
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(prompt).append("\n");
        for(int i=0; i<options.size(); i++) {
            sb.append((char)('A' + i)).append(". ")
                    .append(options.get(i).getText()).append("\n");
        }
        return sb.toString();
    }
}
