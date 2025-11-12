package quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        MultipleChoiceQuestion q1 = new MultipleChoiceQuestion(
                "Which OOP principle allows hiding implementation details?",
                List.of(
                        new Answer("Inheritance", false),
                        new Answer("Encapsulation", true),
                        new Answer("Polymorphism", false),
                        new Answer("Abstraction", false)
                ),
                5
        );

        MultipleChoiceQuestion q2 = new MultipleChoiceQuestion(
                "Which keyword in Java is used for inheritance?",
                List.of(
                        new Answer("implement", false),
                        new Answer("extends", true),
                        new Answer("inherits", false),
                        new Answer("super", false)
                ),
                5
        );

        quiz.addQuestion(q1);
        quiz.addQuestion(q2);

        Scanner scanner = new Scanner(System.in);
        List<String> userAnswers = new ArrayList<>();
        List<Question> qs = quiz.getQuestions();

        for(int i=0; i<qs.size(); i++) {
            System.out.println("\nQuestion " +(i+1)+":");
            System.out.println(qs.get(i).toString());
            System.out.print("Your answer (A/B/C/...): ");
            String ans = scanner.nextLine();
            userAnswers.add(ans);
        }

        int score = quiz.evaluate(userAnswers);
        System.out.println("\n Sample Answers score: " + score + "/ 10");
        scanner.close();
    }
}
