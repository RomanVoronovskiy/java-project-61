package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Even {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run() {
        Engine.startGame(
                GAME_DESCRIPTION,
                generateQuestionAndAnswer(Engine.ROUND_COUNT)
        );
    }

    private static List<String> generateQuestionAndAnswer(int maxTry) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < maxTry; i++) {
            int question = Utils.getRandomNumber();
            String correctAnswer = (question % 2 == 0) ? "yes" : "no";
            data.add(question + "/" + correctAnswer);
        }
        return data;
    }

}
