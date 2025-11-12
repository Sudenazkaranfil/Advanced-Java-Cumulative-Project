package quiz;

import java.util.List;
import java.util.stream.IntStream;

public class MultipleChoiceQuestion extends Question {
    private final List<Answer> options;

    public MultipleChoiceQuestion(String prompt, List<Answer> options, int points) {
        super(prompt, points);
        this.options = options;
    }

    @Override
    public boolean isCorrect(String userAnswer) {
        if(userAnswer == null || userAnswer.isBlank()) {
            return false;
        }
        int index = userAnswer.trim().toUpperCase().charAt(0) - 'A';
        if(index < 0 ||index >= options.size()) {
            return false;
        }
        return options.get(index).isCorrect();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getPrompt()).append("\n");
        IntStream.range(0, options.size()).forEach(i -> sb.append((char)('A' + i)).append(") ").append(options.get(i).getText()).append("\n"));
        return sb.toString();
    }
}
