package quiz;

public class OpenEndedAnswer implements IAnswer {
    private final String text;

    public OpenEndedAnswer(String correctText) {
        this.text = correctText;
    }
    @Override
    public String getText() {
        return text;
    }
    @Override
    public boolean isCorrect() {
        return true;
        // Not used in open-ended questions, but required by interface
    }
}
