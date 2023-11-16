package hexlet.code;

import java.util.Random;

public class Calc {
    public static void play() {
        Random random = new Random();
        Engine.cli();
        Engine.getRulesCalc();
        Engine.calc(random);
    }
}
