package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class GCD {
    private static final String GAME_DESCRIPTION = "Find the greatest common divisor of given numbers.";

    public static void run() {
        Engine.startGame(
                GAME_DESCRIPTION,
                generateQuestionAndAnswer(Engine.ROUND_COUNT)
        );
    }

    private static List<String> generateQuestionAndAnswer(int maxTry) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < maxTry; i++) {
            int numberFirst = Utils.getRandomNumber();
            int numberSecond = Utils.getRandomNumber();
            int gcd = calculateGcd(numberFirst, numberSecond);
            data.add(String.format("%d %d/%d", numberFirst, numberSecond, gcd));
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
