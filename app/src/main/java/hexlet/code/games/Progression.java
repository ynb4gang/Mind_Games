package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.Random;

public class Progression {
    private static final int RANDOM_NUMBER_8 = 8;
    private static final int RANDOM_NUMBER_15 = 15;
    public static void play() {
        getRulesProgression();
        String[][] questionsAndAnswers = questionsAndAnswers();
        Engine.run(questionsAndAnswers);
    }
    private static String[][] questionsAndAnswers() {
        Random random = new Random();
        String[][] questionsAndAnswers = new String[Engine.MAGIC_NUMBER_3][2];
        for (int iterationLimit = 0; iterationLimit < Engine.MAGIC_NUMBER_3; iterationLimit++) {
            int startValue = Utils.getRandomNumber(1,100);
            int step = getRandomStep(random);
            int marker = getRandomMarker(random);
            String check = String.valueOf(startValue + (step * marker));
            String question = generateProgressionQuestion(startValue, step, marker);
            questionsAndAnswers[iterationLimit][0] = question;
            questionsAndAnswers[iterationLimit][1] = check;
        }
        return questionsAndAnswers;
    }
    public static String generateProgressionQuestion(int startValue, int step, int marker) {
        StringBuilder question = new StringBuilder();
        for (int i = 0; i < Engine.SIZE; i++) {
            if (i == marker) {
                question.append(".. ");
            } else {
                question.append(startValue).append(" ");
            }
            startValue = startValue + step;
        }
        return question.toString();
    }
    private static int getRandomStep(Random random) {
        return random.nextInt(RANDOM_NUMBER_15);
    }
    private static int getRandomMarker(Random random) {
        return random.nextInt(RANDOM_NUMBER_8);
    }
    public static void getRulesProgression() {
        System.out.println("What number is missing in the progression?");
    }
}
