package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int GREET_GAME = 1;
    public static final int EVEN_GAME = 2;
    public static final int CALC_GAME = 3;
    public static final int GCD_GAME = 4;
    public static final int PROGRESSION_GAME = 5;
    public static final int PRIME_GAME = 6;
    public static final int EXIT_GAME = 0;
    private static String userName;

    public static void Cli(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
    public static int Greeting(){
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
    public static void Greet(){
        String prompt = "Your answer: ";
        int randomNumber = GetRandomNumber();
        String correctAnswer = randomNumber % 2 == 0 ? "yes" : "no";
        generateQuestion(randomNumber);
        String playerChoice = getUserAnswer(prompt);
        System.out.println(Equals(correctAnswer,playerChoice));
    }

    public static int GetRandomNumber(){
        return (int) (Math.random() * 100);
    }
    public static String Equals(String correctAnswer,String playerChoice) {
        if (playerChoice.equals(correctAnswer)){
            return messageCorrect();
        }else{
            return messageIncorrect(playerChoice,correctAnswer);
        }
    }
    public static String PlayerChoice(){
        Scanner scanner = new Scanner(System.in);
        String playerChoice = scanner.nextLine();
        return playerChoice;
    }
    public static String messageCorrect() {
        return "Correct!";
    }
    public static String messageIncorrect(String userAnswer, String correctAnswer) {
        return "'" + userAnswer + "' is wrong answer ;(. "
                + "Correct answer was '" + correctAnswer + "'.";
    }
    public static String getUserName() {
        return userName;
    }
    public static void generateQuestion(String question) {
        System.out.println("Question: " + question);
    }
    public static void generateQuestion(int question) {
        System.out.println("Question: " + question);
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
    public static String congratulations(){
        return ("Congratulations, " + userName);
    }
}

