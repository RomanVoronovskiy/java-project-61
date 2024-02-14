package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

public class Progression {
    private static final String GAME_DESCRIPTION = "What number is missing in the progression?";

    public void run() {
        Engine.startGame(GAME_DESCRIPTION, Progression::generateQuestionAndAnswer);
    }

    private static String generateQuestionAndAnswer() {
        // Генерируем случайные параметры для прогрессии
        int progressionLength = Utils.getRandomNumberInRange(5, 10);
        int hiddenIndex = Utils.getRandomNumberInRange(0, progressionLength - 1);
        int startNumber = Utils.getRandomNumberInRange(1, 20);
        int difference = Utils.getRandomNumberInRange(1, 5);

        StringBuilder question = new StringBuilder();
        int correctAnswer = startNumber;

        // Создаем прогрессию с пропущенным числом
        for (int i = 0; i < progressionLength; i++) {
            if (i == hiddenIndex) {
                question.append(".. ");
            } else {
                question.append(" ").append(correctAnswer).append(" ");
            }
            correctAnswer += difference;
        }

        // Сохраняем правильный ответ отдельно
        int answer = startNumber + difference * hiddenIndex;

        // Возвращаем вопрос и правильный ответ
        return question.toString() + "/" + answer;
    }
}
