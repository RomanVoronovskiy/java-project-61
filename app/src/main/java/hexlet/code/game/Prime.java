package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void run() {
        Engine.startGame(
                GAME_DESCRIPTION,
                generateQuestionAndAnswer(Engine.ROUND_COUNT)
        );
    }

    public static List<String> generateQuestionAndAnswer(int maxTry) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < maxTry; i++) {
            int number = Utils.getRandomNumber();
            String question = String.valueOf(number);
            String correctAnswer = isPrime(number) ? "yes" : "no";
            data.add(question + "/" + correctAnswer);
        }
        return data;
    }

    /**
     * @param number число для определения
     * @return простое ли число?
     * @apiNote метод отвечает на вопрос переданное число является простым или нет
     */
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
