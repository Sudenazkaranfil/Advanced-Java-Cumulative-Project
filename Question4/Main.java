package quiz;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        QuizImpl<IQuestion<?>> quiz = new QuizImpl<>();

        quiz.addQuestion(
                new MultipleChoiceQuestion(
                        "Which language runs on JVM?", 5,
                        List.of(
                                new MultipleChoiceAnswer("Java", true),
                                new MultipleChoiceAnswer("Python", false),
                                new MultipleChoiceAnswer("C++", false)
                        )
                )
        );

        quiz.addQuestion(
                new MultipleChoiceQuestion(
                        "Which keyword defines a class in Java?", 5,
                        List.of(
                                new MultipleChoiceAnswer("Object", false),
                                new MultipleChoiceAnswer("Class", true),
                                new MultipleChoiceAnswer("Function", false)
                        )
                )
        );

        quiz.addQuestion(
                new OpenEndedQuestion(
                        "Explain what OOP stands for.", 5,
                        "Objects Orianted Programming"
                )
        );
        Scanner sc = new Scanner(System.in);

        System.out.println("1) Start Quiz");
        System.out.println("2) Save Quiz");
        System.out.println("3) Load Quiz");
        System.out.print("Choose: ");
        int ch = Integer.parseInt(sc.nextLine());

        if (ch == 2) {
            quiz.saveQuiz("quiz.json");
        }
        if (ch == 3) {
            quiz.loadQuiz("quiz.json");
        }
        if (ch == 1) {
            List<String> answers = new ArrayList<>();

            System.out.println("\nWelcome to the Quiz:\n");

            for (IQuestion<?> q : quiz.getQuestions()) {
                System.out.println(q);
                System.out.print("Your answer: ");
                answers.add(sc.nextLine());
            }
            int score = quiz.evaluate(answers);
            System.out.println("\nYour total score: " + score);
        }
        sc.close();
    }
}
