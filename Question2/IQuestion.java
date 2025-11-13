package quiz;

public interface IQuestion {
    String getPrompt();
    int getPoints();
    boolean isCorrect(String answer);
}
