package hexlet.code.game;

import hexlet.code.Engine;
import hexlet.code.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class Calc {
    private static final String GAME_DESCRIPTION = "What is the result of the expression?";

    public static void run() {
        Engine.startGame(
                GAME_DESCRIPTION,
                generateQuestionAndAnswer(Engine.ROUND_COUNT)
        );
    }

    /**
     * @param maxTry количество попыток после которых пользователь побеждает
     * @return строка с вопросом
     * @apiNote метод возвращает вопрос для типа игры - калькулятор
     */
    private static List<String> generateQuestionAndAnswer(int maxTry) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < maxTry; i++) {
            int numberFirst = Utils.getRandomNumber();
            int numberSecond = Utils.getRandomNumber();
            char operator = getRandomOperator();
            String question = numberFirst + " " + operator + " " + numberSecond;
            int correctAnswer = calculateResult(numberFirst, numberSecond, operator);
            data.add(question + "/" + correctAnswer);
        }
        return data;
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

    /**
     * @return оператор
     * @apiNote метод извлечения рандомного оператора для калькулятора
     */
    public static char getRandomOperator() {
        char[] operators = {'+', '-', '*'};
        int randomIndex = Utils.getRandomNumberInRange(operators.length - 1);
        return operators[randomIndex];
    }
}
