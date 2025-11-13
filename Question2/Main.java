package quiz;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<IAnswer> answers1 = List.of(
            new MultipleChoiceAnswer("Java", true),
            new MultipleChoiceAnswer("Python", false),
            new MultipleChoiceAnswer("C++", false)
        );

        List<IAnswer> answers2 = List.of(
            new MultipleChoiceAnswer("Object", false),
            new MultipleChoiceAnswer("Class", true),
            new MultipleChoiceAnswer("Function", false)
        );

        IQuestion q1 = new MultipleChoiceQuestion("Which language runs on JVM?", 5, answers1);
        IQuestion q2 = new MultipleChoiceQuestion("Which keyword is used to define a class in Java?", 5, answers2);

        IQuiz quiz = new QuizImpl();
        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

        Scanner scanner = new Scanner(System.in);
        List<String> userAnswers = new java.util.ArrayList<>();

        System.out.println("Welcome to the Quiz! Answer the following questions:");

        for (IQuestion question : quiz.getQuestions()) {
            System.out.println(question);
            System.out.print("Your answer: ");
            String answer = scanner.nextLine();
            userAnswers.add(answer);
        }

        int score = quiz.evaluate(userAnswers);
        System.out.println("Your total score: " + score);

        scanner.close();
    }
}
