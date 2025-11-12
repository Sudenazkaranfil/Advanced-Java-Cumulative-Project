package quiz;

public abstract class Question {
    private final String prompt;
    private final int points;

    public Question(String prompt, int points) {
        this.prompt = prompt;
        this.points = points;
    }

    public String getPrompt() {
        return prompt;
    }

    public int getPoints() {
        return points;
    }

    public abstract boolean isCorrect(String userAnswer);
}
