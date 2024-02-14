package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

public class Progression {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";
    private static final Integer FIVE = 5;
    private static final Integer ONE = 1;
    private static final Integer ZERO = 0;
    private static final Integer TEN = 10;
    private static final Integer TWENTY = 20;

    public void run() {
        Engine.startGame(GAME_DESCRIPTION, Progression::generateQuestionAndAnswer);
    }

    private static String generateQuestionAndAnswer() {
        // Генерируем случайные параметры для прогрессии
        int progressionLength = Utils.getRandomNumberInRange(FIVE, TEN);
        int hiddenIndex = Utils.getRandomNumberInRange(ZERO, progressionLength - ONE);
        int startNumber = Utils.getRandomNumberInRange(ONE, TWENTY);
        int difference = Utils.getRandomNumberInRange(ONE, FIVE);

        StringBuilder question = new StringBuilder();
        int correctAnswer = startNumber;

        // Создаем прогрессию с пропущенным числом
        for (int i = 0; i < progressionLength; i++) {
            if (i == hiddenIndex) {
                question.append(".. ");
            } else {
                question.append(correctAnswer).append(" ");
            }
            correctAnswer += difference;
        }

        // Сохраняем правильный ответ отдельно
        int answer = startNumber + difference * hiddenIndex;

        // Возвращаем вопрос и правильный ответ
        return question.toString() + "/" + answer;
    }
}
