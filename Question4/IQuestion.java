package quiz;

import java.util.List;

public interface IQuestion<A extends IAnswer>{
    String getPrompt();
    int getPoints();
    List<A> getAnswers();
    boolean isCorrect(String userInput);
}
