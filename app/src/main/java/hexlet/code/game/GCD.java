package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

public class GCD {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void run() {
        Engine.startGame(
                GAME_DESCRIPTION,
                generateQuestionAndAnswer(Engine.ROUND_COUNT)
        );
    }

    private static String[][] generateQuestionAndAnswer(int maxTry) {
        String[][] data = new String[maxTry][];
        for (int i = 0; i < maxTry; i++) {
            int numberFirst = Utils.getRandomNumber();
            int numberSecond = Utils.getRandomNumber();
            int gcd = calculateGcd(numberFirst, numberSecond);
            data[i] = new String[]{String.format("%d %d", numberFirst, numberSecond), String.valueOf(gcd)};
        }
        return data;
    }

    private static int calculateGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGcd(b, a % b);
    }
}
