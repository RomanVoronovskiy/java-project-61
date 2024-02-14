package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

public class GCD {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void run() {
        Engine.startGame(
                GAME_DESCRIPTION,
                GCD::generateQuestionAndAnswer
        );
    }

    private static String generateQuestionAndAnswer() {
        int numberFirst = Utils.getRandomNumber();
        int numberSecond = Utils.getRandomNumber();
        int gcd = calculateGcd(numberFirst, numberSecond);

        return String.format("%d %d/%d", numberFirst, numberSecond, gcd);
    }

    private static int calculateGcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGcd(b, a % b);
    }
}
