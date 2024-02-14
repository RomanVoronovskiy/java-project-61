package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

public class Calc {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";

    public static void run() {
        Engine.startGame(
                GAME_DESCRIPTION,
                Calc::generateQuestionAndAnswer
        );
    }

    /**
     * @return строка с вопросом
     * @apiNote метод возвращает вопрос для типа игры - калькулятор
     */
    private static String generateQuestionAndAnswer() {
        int numberFirst = Utils.getRandomNumber();
        int numberSecond = Utils.getRandomNumber();
        char operator = Utils.getRandomOperator();
        String question = numberFirst + " " + operator + " " + numberSecond;
        int correctAnswer = calculateResult(numberFirst, numberSecond, operator);
        return question + "/" + correctAnswer;
    }

    /**
     * @param numberFirst  1 число для выполнения операции
     * @param numberSecond 2 число для выполнения операции
     * @param operator     сама операция(знак)
     * @return ответ в виде числа
     */
    private static int calculateResult(int numberFirst, int numberSecond, char operator) {
        switch (operator) {
            case '+':
                return numberFirst + numberSecond;
            case '-':
                return numberFirst - numberSecond;
            case '*':
                return numberFirst * numberSecond;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
