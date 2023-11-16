package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void play(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String UserName = scanner.nextLine();
        System.out.println("Hello, " + UserName + "!");
        scanner.close();
    }
}
