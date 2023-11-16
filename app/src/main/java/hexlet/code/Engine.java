package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final int WIN_GAME_LIMIT = 3;
    public static final int GREET_GAME = 1;
    public static final int EVEN_GAME = 2;
    public static final int CALC_GAME = 3;
    public static final int GCD_GAME = 4;
    public static final int PROGRESSION_GAME = 5;
    public static final int PRIME_GAME = 6;
    public static final int EXIT_GAME = 0;
    private static final int SIZE = 10;
    private static String userName;
    private static final int STEP_LIMIT = 3;
    private static final int MAGIC_NUMBER_3 = 3;
    private static final int MAGIC_NUMBER_6 = 3;
    private static final int MAGIC_NUMBER_5 = 5;
    private static final int MAGIC_NUMBER_100 = 100;
    private static final int MAGIC_NUMBER_15 = 15;
    private static final int MAGIC_NUMBER_8 = 8;

    private static final int[] RANDOM_NUMBERS = new int[STEP_LIMIT];
    private static final int[] RANDOM_NUMBERS_SECOND = new int[STEP_LIMIT];
    private static final int[] RANDOM_NUMBERS_STEP = new int[STEP_LIMIT];
    private static final int[] RANDOM_NUMBERS_CHECK = new int[STEP_LIMIT];
    private static final int[] RANDOM_NUMBERS_MARKER = new int[STEP_LIMIT];
    private static final String[] CORRECT_ANSWERS_ARRAY = new String[STEP_LIMIT];
    private static final String[] RANDOM_OPERATIONS_ARRAY = new String[STEP_LIMIT];
    public static void cli() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
    public static int greeting() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET_GAME + " - Greet");
        System.out.println(EVEN_GAME + " - Even");
        System.out.println(CALC_GAME + " - Calc");
        System.out.println(GCD_GAME + " - GCD");
        System.out.println(PROGRESSION_GAME + " - Progression");
        System.out.println(PRIME_GAME + " - Prime");
        System.out.println(EXIT_GAME + " - Exit");
        System.out.print("Your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static void greetLoading() {
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            int randomNumber = getRandomNumber();
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            RANDOM_NUMBERS[iterationLimit] = randomNumber;
            CORRECT_ANSWERS_ARRAY[iterationLimit] = correctAnswer;
        }
    }
    public static void greet() {
        int correctCount = 0;
        greetLoading();
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            String prompt = "Your answer: ";
            int randomNumber = RANDOM_NUMBERS[iterationLimit];
            String correctAnswer = CORRECT_ANSWERS_ARRAY[iterationLimit];
            generateQuestion(randomNumber);
            String playerChoice = getUserAnswer(prompt);
            if (correctAnswer.equals(playerChoice)) {
                correctCount++;
                System.out.println(messageCorrect());
            } else {
                System.out.println(messageIncorrect(playerChoice, correctAnswer));
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (correctCount == WIN_GAME_LIMIT) {
            System.out.println(congratulations());
        }
    }
    public static void calcLoading(Random random) {
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            int firstRandomNumber = getRandomNumber();
            int secondRandomNumber = getRandomNumber();
            String[] operations = {"+", "-", "*"};
            String operation = operations[random.nextInt(operations.length)];
            RANDOM_NUMBERS[iterationLimit] = firstRandomNumber;
            RANDOM_NUMBERS_SECOND[iterationLimit] = secondRandomNumber;
            RANDOM_OPERATIONS_ARRAY[iterationLimit] = operation;
        }
    }
    public static void calc(Random random) {
        int correctCount = 0;
        calcLoading(random);
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            int firstRandomNumber = RANDOM_NUMBERS[iterationLimit];
            int secondRandomNumber = RANDOM_NUMBERS_SECOND[iterationLimit];
            String operation = RANDOM_OPERATIONS_ARRAY[iterationLimit];
            int check = 0;
            check = switch (operation) {
                case "+" -> firstRandomNumber + secondRandomNumber;
                case "*" -> firstRandomNumber * secondRandomNumber;
                case "-" -> firstRandomNumber - secondRandomNumber;
                default -> check;
            };
            generateQuestion(firstRandomNumber, secondRandomNumber, operation);
            int playerChoice = getUserAnswer();
            if (check == playerChoice) {
                correctCount++;
                System.out.println(messageCorrect());
            } else {
                System.out.println(messageIncorrect(playerChoice, check));
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (correctCount == WIN_GAME_LIMIT) {
            System.out.println(congratulations());
        }
    }
    public static void loadingGCD() {
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            int firstRandomNumber = getRandomNumber();
            int secondRandomNumber = getRandomNumber();
            RANDOM_NUMBERS[iterationLimit] = firstRandomNumber;
            RANDOM_NUMBERS_SECOND[iterationLimit] = secondRandomNumber;
        }
    }
    public static void gcd() {
        int correctCount = 0;
        loadingGCD();
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            int firstRandomNumber = RANDOM_NUMBERS[iterationLimit];
            int secondRandomNumber = RANDOM_NUMBERS_SECOND[iterationLimit];
            int check = findGCD(firstRandomNumber, secondRandomNumber);
            generateQuestion(firstRandomNumber, secondRandomNumber);
            int playerChoice = getUserAnswer();
            if (check == playerChoice) {
                correctCount++;
                System.out.println(messageCorrect());
            } else {
                System.out.println(messageIncorrect(playerChoice, check));
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (correctCount == WIN_GAME_LIMIT) {
            System.out.println(congratulations());
        }
    }
    public static void progressionLoading() {
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            int startValue = getRandomNumber();
            int step = getRandomStep(new Random());
            int marker = getRandomMarker(new Random());
            int check = startValue + (step * marker);
            RANDOM_NUMBERS[iterationLimit] = startValue;
            RANDOM_NUMBERS_STEP[iterationLimit] = step;
            RANDOM_NUMBERS_MARKER[iterationLimit] = marker;
            RANDOM_NUMBERS_CHECK[iterationLimit] = check;
        }
    }
    public static void progression() {
        progressionLoading();
        int correctCount = 0;
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            int startValue = RANDOM_NUMBERS[iterationLimit];
            int step = RANDOM_NUMBERS_STEP[iterationLimit];
            int marker = RANDOM_NUMBERS_MARKER[iterationLimit];
            int check = RANDOM_NUMBERS_CHECK[iterationLimit];
            generateProgressionQuestion(startValue, step, marker);
            int playerChoice = getUserAnswer();
            if (check == playerChoice) {
                correctCount++;
                System.out.println(messageCorrect());
            } else {
                System.out.println(messageIncorrect(playerChoice, check));
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (correctCount == WIN_GAME_LIMIT) {
            System.out.println(congratulations());
        }
    }
    public static void primeLoading() {
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            int number = getRandomNumber();
            RANDOM_NUMBERS[iterationLimit] = number;
            CORRECT_ANSWERS_ARRAY[iterationLimit] = isPrime(number);
        }
    }

    public static void prime() {
        primeLoading();
        int correctCount = 0;
        for (int iterationLimit = 0; iterationLimit < MAGIC_NUMBER_3; iterationLimit++) {
            String prompt = "Your answer: ";
            int number = RANDOM_NUMBERS[iterationLimit];
            String check = CORRECT_ANSWERS_ARRAY[iterationLimit];
            generateQuestion(number);
            String playerChoice = getUserAnswer(prompt);
            if (check.equals(playerChoice)) {
                correctCount++;
                System.out.println(messageCorrect());
            } else {
                System.out.println(messageIncorrect(playerChoice, check));
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (correctCount == 3) {
            System.out.println(congratulations());
        }
    }
    public static String isPrime(int number) {
        if (number <= 1) {
            return "no";
        }

        if (number == 2 || number == 3) {
            return "yes";
        }

        if (number % 2 == 0 || number % 3 == 0) {
            return "no";
        }

        int i = MAGIC_NUMBER_5;
        int w = 2;

        while (i * i <= number) {
            if (number % i == 0) {
                return "no";
            }

            i += w;
            w = MAGIC_NUMBER_6 - w;
        }

        return "yes";
    }




    public static int getRandomNumber() {
        return (int) (Math.random() * MAGIC_NUMBER_100);
    }
    public static int getRandomStep(Random random) {
        return random.nextInt(MAGIC_NUMBER_15);
    }
    public static int getRandomMarker(Random random) {
        return random.nextInt(MAGIC_NUMBER_8);
    }
    public static String messageCorrect() {
        return "Correct!";
    }
    public static String messageIncorrect(String userAnswer, String correctAnswer) {
        return "'" + userAnswer + "' is wrong answer ;(. "
                + "Correct answer was '" + correctAnswer + "'.";
    }
    public static String messageIncorrect(int userAnswer, int correctAnswer) {
        return "'" + userAnswer + "' is wrong answer ;(. "
                + "Correct answer was '" + correctAnswer + "'.";
    }
    public static void generateQuestion(int question) {
        System.out.println("Question: " + question);
    }
    public static void generateQuestion(int firstNumber, int secondNumber, String operation) {
        System.out.println("Question: " + firstNumber + " " + operation + " " + secondNumber);
    }
    public static void generateProgressionQuestion(int startValue, int step, int marker) {
        System.out.print("Question: ");
        for (int i = 0; i < SIZE; i++) {
            if (i == marker) {
                System.out.print(".. ");
            } else {
                System.out.print(startValue + " ");
            }
            startValue = startValue + step;
        }
        System.out.println();
    }

    public static void generateQuestion(int firstNumber, int secondNumber) {
        System.out.println("Question: " + firstNumber + " " + secondNumber);
    }
    public static int getUserAnswer() {
        System.out.print("Your answer: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public static String getUserAnswer(String prompt) {
        System.out.print(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static String congratulations() {
        return ("Congratulations, " + userName + "!");
    }
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
    public static void getRulesGreet() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
    public static void getRulesCalc() {
        System.out.println("What is the result of the expression?");
    }
    public static void getRulesGCD() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }
    public static void getRulesProgression() {
        System.out.println("What number is missing in the progression?");
    }
    public static void getRulesPrime() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }
}




