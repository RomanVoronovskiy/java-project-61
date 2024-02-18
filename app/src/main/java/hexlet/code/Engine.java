package hexlet.code;

import java.util.List;
import java.util.Scanner;

public class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final int ROUND_COUNT = 3;

    public static void startGame(String gameDescription, List<String> questionAndAnswerData) {
        String userName = welcomeUser();
        System.out.println(gameDescription);

        for (int i = 0; i < ROUND_COUNT; i++) {
            String questionAndAnswer = questionAndAnswerData.get(i);
            String[] parts = questionAndAnswer.split("/");

            StringBuilder question = new StringBuilder();
            for (int j = 0; j < parts.length - 1; j++) {
                question.append(parts[j]);
            }
            String correctAnswer = parts[parts.length - 1];

            System.out.println("Question: " + question);
            String userAnswer = askForAnswer();

            if (!userAnswer.equals(correctAnswer)) {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, userAnswer, correctAnswer, userName);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!", userName);
    }

    /**
     * @return ответ пользователя
     * @apiNote метод служит для запроса ответа от пользователя
     */
    public static String askForAnswer() {
        System.out.print("Your answer: ");
        return SCANNER.nextLine();
    }

    /**
     * @return имя пользователя
     * @apiNote метод служит для знакомства и приветствия пользователя
     */
    public static String welcomeUser() {
        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?
                """);
        String name = SCANNER.nextLine();
        System.out.printf("Hello, %s! \n", name);
        return name;
    }

}
