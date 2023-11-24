package hexlet.code;

import java.util.Scanner;


public class Engine {
    private static final int WIN_GAME_LIMIT = 3;
    public static final int GREET_GAME = 1;
    public static final int EVEN_GAME = 2;
    public static final int CALC_GAME = 3;
    public static final int GCD_GAME = 4;
    public static final int PROGRESSION_GAME = 5;
    public static final int PRIME_GAME = 6;
    public static final int EXIT_GAME = 0;
    public static final int SIZE = 10;
    private static String userName;
    public static final int MAGIC_NUMBER_3 = 3;
    public static final int RANDOM_NUMBER_100 = 100;
    public static void cli() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
    public static int greeting() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_GAME + " - Greet");
        System.out.println(EVEN_GAME + " - Even");
        System.out.println(CALC_GAME + " - Calc");
        System.out.println(GCD_GAME + " - GCD");
        System.out.println(PROGRESSION_GAME + " - Progression");
        System.out.println(PRIME_GAME + " - Prime");
        System.out.println(EXIT_GAME + " - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static void run(String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);
        cli();
        int correctCount = 0;
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            String question = questionsAndAnswers[iterationLimit][0];
            String correctAnswer = questionsAndAnswers[iterationLimit][1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            if (correctAnswer.equals(userAnswer)) {
                correctCount++;
                System.out.println(messageCorrect());
            } else {
                System.out.println(messageIncorrect(userAnswer, correctAnswer));
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (correctCount == WIN_GAME_LIMIT) {
            System.out.println(congratulations());
        }
    }
    public static int getRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_100);
    }
    public static String messageCorrect() {
        return "Correct!";
    }
    public static String messageIncorrect(String userAnswer, String correctAnswer) {
        return "'" + userAnswer + "' is wrong answer ;(. "
                + "Correct answer was '" + correctAnswer + "'.";
    }
    public static String congratulations() {
        return ("Congratulations, " + userName + "!");
    }
    public static void getRulesGreet() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
    public static void getRulesCalc() {
        System.out.println("What is the result of the expression?");
    }
    public static void getRulesGCD() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }
    public static void getRulesProgression() {
        System.out.println("What number is missing in the progression?");
    }
    public static void getRulesPrime() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }
}
