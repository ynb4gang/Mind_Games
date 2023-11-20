package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static void play() {
        Engine.getRulesGCD();
        String[][] questionsAndAnswers = questionsAndAnswers();
        Engine.run(questionsAndAnswers);
    }
    private static String[][] questionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.MAGIC_NUMBER_3][2];
        for (int iterationLimit = 0; iterationLimit < Engine.MAGIC_NUMBER_3; iterationLimit++) {
            int firstRandomNumber = Engine.getRandomNumber();
            int secondRandomNumber = Engine.getRandomNumber();
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
