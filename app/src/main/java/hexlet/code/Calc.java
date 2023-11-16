package hexlet.code;

import java.util.Random;

public class Calc {
    public static void play() {
        Random random = new Random();
        Engine.Cli();
        System.out.println("What is the result of the expression?");
        Engine.Calc(random);
    }
}
