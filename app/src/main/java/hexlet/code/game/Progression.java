package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Progression {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final Integer FIVE = 5;
    private static final Integer ONE = 1;
    private static final Integer ZERO = 0;
    private static final Integer TEN = 10;
    private static final Integer TWENTY = 20;

    public static void run() {
        Engine.startGame(
                GAME_DESCRIPTION,
                generateQuestionAndAnswer(Engine.ROUND_COUNT)
        );
    }

    private static List<String> generateQuestionAndAnswer(int maxTry) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < maxTry; i++) {
            int progressionLength = Utils.getRandomNumberInRange(FIVE, TEN);
            int hiddenIndex = Utils.getRandomNumberInRange(ZERO, progressionLength - ONE);
            int startNumber = Utils.getRandomNumberInRange(ONE, TWENTY);
            int difference = Utils.getRandomNumberInRange(ONE, FIVE);
            StringBuilder question = new StringBuilder();
            int correctAnswer = startNumber;

            generateProgressive(progressionLength, hiddenIndex, question, correctAnswer, difference);
            int answer = getAnswer(startNumber, difference, hiddenIndex);

            data.add(question + "/" + answer);
        }
        return data;
    }

    /**
     * @param startNumber первый член прогрессии
     * @param difference  разность прогрессии
     * @param hiddenIndex пропущенный индекс
     * @return пропущенное значение
     * @apiNote метод возращает пропущенное в последовательности значение <br>
     * с помощью формулы нахождения n-го члена прогрессии
     */
    private static int getAnswer(int startNumber, int difference, int hiddenIndex) {
        return startNumber + difference * hiddenIndex;
    }

    /**
     * @param progressionLength длинна прогрессии
     * @param hiddenIndex       пропущенный индекс
     * @param question          вопрос
     * @param correctAnswer     корректный ответ
     * @param difference        разность прогрессии
     * @apiNote метод генерирует прогрессию с пропущенным числоим
     */
    private static void generateProgressive(int progressionLength, int hiddenIndex, StringBuilder question, int correctAnswer, int difference) {
        for (int j = 0; j < progressionLength; j++) {
            if (j == hiddenIndex) {
                question.append(".. ");
            } else {
                question.append(correctAnswer).append(" ");
            }
            correctAnswer += difference;
        }
    }
}
