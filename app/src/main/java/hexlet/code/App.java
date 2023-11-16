package hexlet.code;

public class App extends Engine{
    public static void main(String[] args) {
        int gameNumber = Greeting();
        switch (gameNumber){
            case Engine.GREET_GAME:
                Cli.play();
                break;
            case Engine.EVEN_GAME:
                Greet.play();
                break;
            case Engine.CALC_GAME:
                Calc.play();
                break;
            case Engine.GCD_GAME:
                GCD.play();
                break;
            case Engine.PROGRESSION_GAME:
                Progression.play();
                break;
            case PRIME_GAME:
                Prime.play();
                break;
            case Engine.EXIT_GAME:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid game number.");
        }
    }
}
