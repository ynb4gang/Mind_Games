package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
public class GCD {
    private static final int MAX_RANDOM_NUMBER_60 = 60;
    private static final String RULES = "Find the greatest common divisor of given numbers.";
    public static void play() {
        String[][] questionsAndAnswers = questionsAndAnswers();
        Engine.run(questionsAndAnswers, RULES);
    }
    private static String[][] questionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.WIN_GAME_LIMIT][2];
        for (int iterationLimit = 0; iterationLimit < Engine.WIN_GAME_LIMIT; iterationLimit++) {
            int firstRandomNumber = Utils.getRandomNumber(1, MAX_RANDOM_NUMBER_60);
            int secondRandomNumber = Utils.getRandomNumber(1, MAX_RANDOM_NUMBER_60);
            String question = firstRandomNumber + " " + secondRandomNumber;
            String correctAnswer = String.valueOf(findGCD(firstRandomNumber, secondRandomNumber));
            questionsAndAnswers[iterationLimit][0] = question;
            questionsAndAnswers[iterationLimit][1] = correctAnswer;
        }
        return questionsAndAnswers;
    }
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
