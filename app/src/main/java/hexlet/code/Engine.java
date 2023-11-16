package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static int WIN_GAME = 3;
    public static final int GREET_GAME = 1;
    public static final int EVEN_GAME = 2;
    public static final int CALC_GAME = 3;
    public static final int GCD_GAME = 4;
    public static final int PROGRESSION_GAME = 5;
    public static final int PRIME_GAME = 6;
    public static final int EXIT_GAME = 0;
    private static final int SIZE = 10;
    public static String userName;
    private static final int[] randomNumbersArray = new int[3];
    private static final int[] randomNumbersArraySecond = new int[3];
    private static final int[] randomNumbersArrayStep = new int[3];
    private static final int[] randomNumbersArrayCheck = new int[3];
    private static final int[] randomNumbersArrayMarker = new int[3];
    private static final String[] correctAnswersArray = new String[3];
    private static final String[] randomOperationsArray = new String[3];
    public static void Cli() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
    public static int Greeting() {
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
    public static void GreetLoading() {
        for(int i = 0; i < 3; i ++){
            int randomNumber = GetRandomNumber();
            String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
            randomNumbersArray[i] = randomNumber;
            correctAnswersArray[i] = correctAnswer;
        }
    }
    public static void Greet() {
        int correctCount = 0;
        GreetLoading();
        for (int i = 0; i < 3; i++){
            String prompt = "Your answer: ";
            int randomNumber = randomNumbersArray[i];
            String correctAnswer = correctAnswersArray[i];
            generateQuestion(randomNumber);
            String playerChoice = getUserAnswer(prompt);
            if (correctAnswer.equals(playerChoice)){
                correctCount++;
                System.out.println(messageCorrect());
            } else{
                System.out.println(messageIncorrect(playerChoice,correctAnswer));
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }
        if (correctCount == WIN_GAME){
            System.out.println(congratulations());
        }
    }
    public static void CalcLoading(Random random){
        for (int i = 0; i < 3; i++){
            int firstRandomNumber = GetRandomNumber();
            int secondRandomNumber = GetRandomNumber();
            String[] operations = {"+", "-", "*"};
            String operation = operations[random.nextInt(operations.length)];
            randomNumbersArray[i] = firstRandomNumber;
            randomNumbersArraySecond[i] = secondRandomNumber;
            randomOperationsArray[i] = operation;
        }
    }
    public static void Calc(Random random) {
        int correctCount = 0;
        CalcLoading(random);
        for (int i = 0; i < 3; i++) {
            int firstRandomNumber = randomNumbersArray[i];
            int secondRandomNumber = randomNumbersArraySecond[i];
            String operation = randomOperationsArray[i];
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
        if (correctCount == WIN_GAME){
            System.out.println(congratulations());
        }
    }
    public static void LoadingGCD(){
        for (int i = 0 ; i < 3; i++){
            int firstRandomNumber = GetRandomNumber();
            int secondRandomNumber = GetRandomNumber();
            randomNumbersArray[i] = firstRandomNumber;
            randomNumbersArraySecond[i] = secondRandomNumber;
        }
    }
    public static void GCD() {
        int correctCount = 0;
        LoadingGCD();
        for (int i = 0 ; i < 3; i++) {
            int firstRandomNumber = randomNumbersArray[i];
            int secondRandomNumber = randomNumbersArraySecond[i];
            int check = FindGCD(firstRandomNumber, secondRandomNumber);
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
        if (correctCount == WIN_GAME){
            System.out.println(congratulations());
        }
    }
    public static void ProgressionLoading(){
        for(int i = 0 ; i < 3; i++){
            int startValue = GetRandomNumber();
            int step = GetRandomStep(new Random());
            int marker = GetRandomMarker(new Random());
            int check = startValue + (step * marker);
            randomNumbersArray[i] = startValue;
            randomNumbersArrayStep[i] = step;
            randomNumbersArrayMarker[i] = marker;
            randomNumbersArrayCheck[i] = check;
        }
    }
    public static void Progression(){
        ProgressionLoading();
        int correctCount = 0;
        for(int i = 0 ; i < 3; i++) {
            int startValue = randomNumbersArray[i];
            int step = randomNumbersArrayStep[i];
            int marker = randomNumbersArrayMarker[i];
            int check = randomNumbersArrayCheck[i];
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
        if (correctCount == WIN_GAME){
            System.out.println(congratulations());
        }
    }
    public static void PrimeLoading(){
        for(int i = 0 ; i < 3; i++){
            int number  = GetRandomNumber();
            randomNumbersArray[i] = number;
            correctAnswersArray[i] = isPrime(number);
        }
    }
    public static void Prime() {
        PrimeLoading();
        int correctCount = 3;
        for(int i = 0 ; i < 3; i++){
            String prompt = "Your answer: ";
            int number  = randomNumbersArray[i];
            String check = correctAnswersArray[i];
            generateQuestion(number);
            String playerChoice = getUserAnswer(prompt);
            if (check.equals(playerChoice)){
                correctCount++;
                System.out.println(messageCorrect());
            } else {
                System.out.println(messageIncorrect(playerChoice, check));
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
            if (correctCount == WIN_GAME){
                System.out.println(congratulations());
            }
        }
    }
    public static String isPrime(int number) {
        if (number <= 1) {
            return "no";
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return "no";
            }
        }

        return "yes";
    }
    public static int GetRandomNumber() {
        return (int) (Math.random() * 100);
    }
    public static int GetRandomStep(Random random) {
        return random.nextInt(15);
    }
    public static int GetRandomMarker(Random random) {
        return random.nextInt(8);
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
    public static void generateQuestion(int firstNumber,int secondNumber, String operation) {
        System.out.println("Question: " + firstNumber + operation + secondNumber);
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

    public static void generateQuestion(int firstNumber,int secondNumber) {
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
    public static int FindGCD(int a, int b) {
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
        System.out.println("Answer 'yes' if the number is prime, otherwise answer 'no'.");
    }
}




