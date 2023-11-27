package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
public class Greet {
    public static void play() {
        getRulesGreet();
        String[][] questionsAndAnswers = questionsAndAnswers();
        Engine.run(questionsAndAnswers);
    }
    private static String[][] questionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.MAGIC_NUMBER_3][2];
        for (int iterationLimit = 0; iterationLimit < Engine.MAGIC_NUMBER_3; iterationLimit++) {
            int randomNumber = Utils.getRandomNumber(1,100);
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            questionsAndAnswers[iterationLimit][0] = String.valueOf(randomNumber);
            questionsAndAnswers[iterationLimit][1] = correctAnswer;
        }
        return questionsAndAnswers;
    }
    public static void getRulesGreet() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
}
