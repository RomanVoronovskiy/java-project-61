package hexlet.util;

import java.util.Scanner;
import hexlet.code.Engine;

public class Cli {
    public static void welcomeUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                Welcome to the Brain Games!
                May I have your name?
                """);
        String name = scanner.nextLine();
        System.out.printf("Hello, %s! \n", name);
        Engine.setUserName(name);
    }
}
