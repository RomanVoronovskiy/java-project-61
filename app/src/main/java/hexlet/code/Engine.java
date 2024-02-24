package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final int ROUND_COUNT = 3;

    public static void startGame(String gameDescription, String[][] questionAndAnswerData) {
        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?
                """);
        String userName = SCANNER.nextLine();
        System.out.printf("Hello, %s! \n", userName);
        System.out.println(gameDescription);

        for (int i = 0; i < ROUND_COUNT; i++) {
            String question = questionAndAnswerData[i][0];
            String correctAnswer = questionAndAnswerData[i][1];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = SCANNER.nextLine();
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
}
