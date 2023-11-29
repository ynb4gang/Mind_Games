package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
public class Calc {
    private static final int MAX_RANDOM_NUMBER_20 = 20;
    private static final String RULES = "What is the result of the expression?";
    public static void play() {
        String[][] questionsAndAnswers = questionsAndAnswers();
        Engine.run(questionsAndAnswers, RULES);
    }
    private static String[][] questionsAndAnswers() {
        String[][] questionsAndAnswers = new String[Engine.WIN_GAME_LIMIT][2];
        for (int iterationLimit = 0; iterationLimit < Engine.WIN_GAME_LIMIT; iterationLimit++) {
            int firstRandomNumber = Utils.getRandomNumber(1, MAX_RANDOM_NUMBER_20);
            int secondRandomNumber = Utils.getRandomNumber(1, MAX_RANDOM_NUMBER_20);
            String[] operations = {"+", "-", "*"};
            String operation = Utils.getRandomOperation(operations);
            String question = firstRandomNumber + " " + operation + " " + secondRandomNumber;
            String correctAnswer = String.valueOf(generateQuestion(firstRandomNumber, operation, secondRandomNumber));
            questionsAndAnswers[iterationLimit][0] = question;
            questionsAndAnswers[iterationLimit][1] = correctAnswer;
        }
        return questionsAndAnswers;
    }
    private static int generateQuestion(int firstNumber, String operation, int secondNumber) {
        return switch (operation) {
            case "+" -> firstNumber + secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "-" -> firstNumber - secondNumber;
            default -> throw new Error("Unknown operator: " + operation);
        };
    }
}
