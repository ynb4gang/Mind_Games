package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
public class GCD {
    private static final int RANDOM_NUMBER_60 = 60;
    public static void play() {
        getRulesGCD();
        String[][] questionsAndAnswers = questionsAndAnswers();
        Engine.run(questionsAndAnswers);
    }
    private static String[][] questionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.MAGIC_NUMBER_3][2];
        for (int iterationLimit = 0; iterationLimit < Engine.MAGIC_NUMBER_3; iterationLimit++) {
            int firstRandomNumber = Utils.getRandomNumber(1, RANDOM_NUMBER_60);
            int secondRandomNumber = Utils.getRandomNumber(1, RANDOM_NUMBER_60);
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
    public static void getRulesGCD() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }
}
