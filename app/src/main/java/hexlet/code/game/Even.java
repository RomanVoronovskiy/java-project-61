package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

public class Even {
    private static final String GAME_DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void run() {
        Engine.startGame(
                GAME_DESCRIPTION,
                Even::generateQuestionAndAnswer
        );
    }


    private static String generateQuestionAndAnswer() {
        int question = Utils.getRandomNumber();
        String correctAnswer = (question % 2 == 0) ? "yes" : "no";
        return question + "/" + correctAnswer;
    }

}
