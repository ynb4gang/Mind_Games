package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Cli;
import hexlet.code.games.GCD;
import hexlet.code.games.Greet;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static final int GREET_GAME = 1;
    public static final int EVEN_GAME = 2;
    public static final int CALC_GAME = 3;
    public static final int GCD_GAME = 4;
    public static final int PROGRESSION_GAME = 5;
    public static final int PRIME_GAME = 6;
    public static final int EXIT_GAME = 0;

    public static void main(String[] args) {
        int gameNumber = greeting();
        switch (gameNumber) {
            case GREET_GAME:
                Cli.greeting();
                break;
            case EVEN_GAME:
                Greet.play();
                break;
            case CALC_GAME:
                Calc.play();
                break;
            case GCD_GAME:
                GCD.play();
                break;
            case PROGRESSION_GAME:
                Progression.play();
                break;
            case PRIME_GAME:
                Prime.play();
                break;
            case EXIT_GAME:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid game number.");
        }
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
}
