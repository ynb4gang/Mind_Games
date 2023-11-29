package hexlet.code;

import java.util.Scanner;


public class Engine {
    public static final int WIN_GAME_LIMIT = 3;
    public static final String WELCOME = "\nWelcome to the Brain Games!\nMay I have your name? ";
    public static void run(String[][] questionsAndAnswers, String rules) {
        System.out.print(WELCOME);
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(rules);
        int correctCount = 0;
        for (int iterationLimit = 0; iterationLimit < WIN_GAME_LIMIT; iterationLimit++) {
            String question = questionsAndAnswers[iterationLimit][0];
            String correctAnswer = questionsAndAnswers[iterationLimit][1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            if (correctAnswer.equals(userAnswer)) {
                correctCount++;
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (correctCount == WIN_GAME_LIMIT) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
