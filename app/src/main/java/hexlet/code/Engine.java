package hexlet.code;

import hexlet.util.Cli;
import hexlet.util.QuestionGenerator;
import hexlet.util.Utils;

public class Engine {

    private static String userName;

    public static void startGame(String gameDescription, QuestionGenerator questionGenerator) {
        Cli.welcomeUser();
        runGame(gameDescription, questionGenerator);
    }


    public static void runGame(String gameDescription, QuestionGenerator questionGenerator) {

        System.out.println(gameDescription);

        final int roundsCount = 3;
        for (int i = 0; i < roundsCount; i++) {
            String questionAndAnswer = questionGenerator.generateQuestionAndAnswer();
            String[] parts = questionAndAnswer.split("/");

            StringBuilder question = new StringBuilder();
            for (int j = 0; j < parts.length - 1; j++) {
                question.append(parts[j]);
            }
            String correctAnswer = parts[parts.length - 1];

            System.out.println("Question: " + question);
            String userAnswer = Utils.askForAnswer();

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

    public static void setUserName(String userName) {
        Engine.userName = userName;
    }
}
