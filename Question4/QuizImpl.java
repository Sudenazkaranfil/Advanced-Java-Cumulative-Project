package quiz;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class QuizImpl<T extends IQuestion<?>> extends Quiz<T> implements IStorage {

    @Override
    public void saveQuiz(String filename) {
        try (Writer writer = new FileWriter(filename)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(this, writer);
            System.out.println("Quiz saved to " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadQuiz(String filename) {
        try (Reader reader = new FileReader(filename)) {
            Gson gson = new Gson();
            QuizImpl<T> loaded = gson.fromJson(reader, QuizImpl.class);

            this.questions.clear();
            this.questions.addAll(loaded.questions);

            System.out.println("Quiz loaded from " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
