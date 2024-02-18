package hexlet.code.util;

import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random();
    private static final Integer MAX = 100;
    private static final Integer MIN = 0;

    public static int getRandomNumber() {
        return RANDOM.nextInt(MAX) + 1;
    }

    public static int getRandomNumberInRange(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }

    public static int getRandomNumberInRange(int max) {
        return getRandomNumberInRange(MIN, max);
    }
}
