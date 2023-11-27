package hexlet.code.games;

import java.util.Scanner;

public class Cli {
    private static String userName;
    public static void play() {
        cli();
    }
    public static void cli() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }
}
