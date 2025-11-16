package quiz;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        List<MultipleChoiceAnswer> answers1 = List.of(
                new MultipleChoiceAnswer("Java", true),
                new MultipleChoiceAnswer("Python", false),
                new MultipleChoiceAnswer("C++", false)
        );
        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion(
                "Which language runs on JVM?", 5,answers1);

        List<MultipleChoiceAnswer> answers2 = List.of(
                new MultipleChoiceAnswer("Object", false),
                new MultipleChoiceAnswer("Class", true),
                new MultipleChoiceAnswer("Function", false)
        );
        MultipleChoiceQuestion q2 = new MultipleChoiceQuestion(
                "Which keyword is used to define a class in Java?", 5, answers2
        );

        OpenEndedQuestion q3 = new OpenEndedQuestion(
                "Explain what OOP stands for.", 5, "Objects Orianted Programming"
        );

        Quiz<IQuestion<?>> quiz = new Quiz<>();
        quiz.addQuestion(q1);
        quiz.addQuestion(q2);
        quiz.addQuestion(q3);

        Scanner scanner = new Scanner(System.in);
        List<String> userAnswers = new ArrayList<>();

        System.out.println("Welcome to the Quiz! Answer the following questions:\n");

        for(IQuestion<?> question : quiz.getQuestions()) {
            System.out.println(question);
            System.out.print("Your answer: ");
            String input = scanner.nextLine();
            userAnswers.add(input);
        }

        int score = quiz.evaluate(userAnswers);
        System.out.println("\nYour total score: " + score);

        scanner.close();
    }
}
