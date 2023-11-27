package hexlet.code;

import java.util.Random;

public class Utils {
    public static int getRandomNumber(int firstNumber, int finalNumber) {
        Random random = new Random();
        return random.nextInt(finalNumber - firstNumber + 1) + firstNumber;
    }
}
