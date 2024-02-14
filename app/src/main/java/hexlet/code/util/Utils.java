package hexlet.code.util;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int getRandomNumber() {
        return RANDOM.nextInt(100) + 1;
    }

    public static char getRandomOperator() {
        char[] operators = {'+', '-', '*'};
        int randomIndex = RANDOM.nextInt(operators.length);
        return operators[randomIndex];
    }

    public static String askForAnswer() {
        System.out.print("Your answer: ");
        return SCANNER.nextLine();
    }

    public static int getRandomNumberInRange(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}
