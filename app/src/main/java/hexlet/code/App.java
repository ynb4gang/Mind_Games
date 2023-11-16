package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Cli;
import hexlet.code.games.GCD;
import hexlet.code.games.Greet;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App extends Engine {
    public static void main(String[] args) {
        int gameNumber = greeting();
        switch (gameNumber) {
            case GREET_GAME:
                Cli.play();
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
}
