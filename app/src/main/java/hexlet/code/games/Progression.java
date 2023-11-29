package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;


public class Progression {
    private static final int MAX_RANDOM_NUMBER_15 = 15;
    private static final int MAX_RANDOM_NUMBER_100 = 100;
    public static final int MIN_ARRAY_SIZE = 5;
    public static final int MAX_ARRAY_SIZE = 10;
    private static final String RULES = "What number is missing in the progression?";

    public static void play() {
        String[][] questionsAndAnswers = questionsAndAnswers();
        Engine.run(questionsAndAnswers, RULES);
    }

    private static String[][] questionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.WIN_GAME_LIMIT][2];
        for (int iterationLimit = 0; iterationLimit < Engine.WIN_GAME_LIMIT; iterationLimit++) {
            int sizeProgression = Utils.getRandomNumber(MIN_ARRAY_SIZE, MAX_ARRAY_SIZE);
            int startValue = Utils.getRandomNumber(1, MAX_RANDOM_NUMBER_100);
            int step = Utils.getRandomNumber(1, MAX_RANDOM_NUMBER_15);
            int marker = Utils.getRandomNumber(1, sizeProgression);
            String check = String.valueOf(startValue + (step * marker));
            String[] question = generateProgressionQuestion(startValue, step, sizeProgression);
            question[marker] = "..";
            String finalQuestion =  String.join(" ", question);
            questionsAndAnswers[iterationLimit][0] = finalQuestion;
            questionsAndAnswers[iterationLimit][1] = check;
        }
        return questionsAndAnswers;
    }

    public static String[] generateProgressionQuestion(int startValue, int step, int sizeProgression) {
        String[] progression = new String[sizeProgression];
        for (int i = 0; i < sizeProgression; i++) {
            progression[i] = String.valueOf(startValue + step * i);
        }
        return progression;
    }
}
