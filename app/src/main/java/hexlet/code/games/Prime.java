package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
public class Prime {
    private static final int MAX_RANDOM_NUMBER_200 = 200;
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void play() {
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(questionsAndAnswers, RULES);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.WIN_GAME_LIMIT][2];
        for (int iterationLimit = 0; iterationLimit < Engine.WIN_GAME_LIMIT; iterationLimit++) {
            int number = Utils.getRandomNumber(1, MAX_RANDOM_NUMBER_200);
            String numberString = String.valueOf(number);
            questionsAndAnswers[iterationLimit][0] = numberString;
            questionsAndAnswers[iterationLimit][1] = isPrime(number) ? "yes" : "no";
        }
        return questionsAndAnswers;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i += 1) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
