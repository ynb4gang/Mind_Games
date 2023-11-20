package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    private static final int DIVISOR_6 = 3;
    private static final int DIVISOR_5 = 5;
    public static void play() {
        Engine.getRulesPrime();
        String[][] questionsAndAnswers = questionsAndAnswers();
        Engine.run(questionsAndAnswers);
    }
    private static String[][] questionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.MAGIC_NUMBER_3][2];
        for (int iterationLimit = 0; iterationLimit < Engine.MAGIC_NUMBER_3; iterationLimit++) {
            int number = Engine.getRandomNumber();
            String numberString = String.valueOf(Engine.getRandomNumber());
            questionsAndAnswers[iterationLimit][0] = numberString;
            questionsAndAnswers[iterationLimit][1] = isPrime(number);
        }
        return questionsAndAnswers;
    }
    public static String isPrime(int number) {
        if (number <= 1) {
            return "no";
        }
        if (number == 2 || number == Engine.MAGIC_NUMBER_3) {
            return "yes";
        }
        if (number % 2 == 0 || number % Engine.MAGIC_NUMBER_3 == 0) {
            return "no";
        }
        int i = DIVISOR_5;
        int w = 2;
        while (i * i <= number) {
            if (number % i == 0) {
                return "no";
            }

            i += w;
            w = DIVISOR_6 - w;
        }
        return "yes";
    }
}
