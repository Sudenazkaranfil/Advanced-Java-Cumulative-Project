package quiz;

public interface IStorage {
    void saveQuiz(String filename);
    void loadQuiz(String filename);
}
