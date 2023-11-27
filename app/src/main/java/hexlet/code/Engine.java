package hexlet.code;

import hexlet.code.games.Cli;

import java.util.Scanner;


public class Engine {
    private static final int WIN_GAME_LIMIT = 3;
    public static final int MAGIC_NUMBER_3 = 3;
    public static void run(String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);
        Cli.cli();
        int correctCount = 0;
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
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
                System.out.println("Let's try again, " + Cli.userName + "!");
                break;
            }
        }
        if (correctCount == WIN_GAME_LIMIT) {
            System.out.println("Congratulations, " + Cli.userName + "!");
        }
    }
}
