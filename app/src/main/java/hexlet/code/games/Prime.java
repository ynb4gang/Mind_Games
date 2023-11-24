package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final int DIVISOR_6 = 3;
    private static final int DIVISOR_5 = 5;

    public static void play() {
        Engine.getRulesPrime();
        String[][] questionsAndAnswers = generateQuestionsAndAnswers();
        Engine.run(questionsAndAnswers);
    }

    private static String[][] generateQuestionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.MAGIC_NUMBER_3][2];
        for (int iterationLimit = 0; iterationLimit < Engine.MAGIC_NUMBER_3; iterationLimit++) {
            int number = Engine.getRandomNumber();
            String numberString = String.valueOf(number);
            questionsAndAnswers[iterationLimit][0] = numberString;
            questionsAndAnswers[iterationLimit][1] = isPrime(number) ? "yes" : "no";
        }
        return questionsAndAnswers;
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == DIVISOR_6) {
            return true;
        }
        if (number % 2 == 0 || number % DIVISOR_6 == 0) {
            return false;
        }
        int divisor = DIVISOR_5;
        int step = 2;
        while (divisor * divisor <= number) {
            if (number % divisor == 0) {
                return false;
            }
            divisor += step;
            step = DIVISOR_6 - step;
        }
        return true;
    }
}
