package quiz;

public class MultipleChoiceAnswer implements IAnswer {
    private final String text;
    private final boolean isCorrect;

    public MultipleChoiceAnswer(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    @Override
    public String getText() {
        return text;
    }
    @Override
    public boolean isCorrect() {
        return isCorrect;
    }
}
