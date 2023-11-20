package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Random;

public class Calc {
    public static void play() {
        Random random = new Random();
        Engine.getRulesCalc();
        String[][] questionsAndAnswers = questionsAndAnswers(random);
        Engine.run(questionsAndAnswers);
    }
    private static String[][] questionsAndAnswers(Random random) {
        String[][] questionsAndAnswers = new String[Engine.MAGIC_NUMBER_3][2];
        for (int iterationLimit = 0; iterationLimit < Engine.MAGIC_NUMBER_3; iterationLimit++) {
            int firstRandomNumber = Engine.getRandomNumber();
            int secondRandomNumber = Engine.getRandomNumber();
            String[] operations = {"+", "-", "*"};
            String operation = operations[random.nextInt(operations.length)];
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
