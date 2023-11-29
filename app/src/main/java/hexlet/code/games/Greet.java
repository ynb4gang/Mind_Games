package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
public class Greet {
    private static final int MAX_RANDOM_NUMBER_100 = 100;
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static void play() {
        String[][] questionsAndAnswers = questionsAndAnswers();
        Engine.run(questionsAndAnswers, RULES);
    }
    private static String[][] questionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.WIN_GAME_LIMIT][2];
        for (int iterationLimit = 0; iterationLimit < Engine.WIN_GAME_LIMIT; iterationLimit++) {
            int randomNumber = Utils.getRandomNumber(1, MAX_RANDOM_NUMBER_100);
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            questionsAndAnswers[iterationLimit][0] = String.valueOf(randomNumber);
            questionsAndAnswers[iterationLimit][1] = correctAnswer;
        }
        return questionsAndAnswers;
    }
}
