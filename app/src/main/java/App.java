import hexlet.game.Calc;
import hexlet.game.Even;
import hexlet.game.Exit;
import hexlet.game.GCD;
import hexlet.game.Prime;
import hexlet.game.Progression;
import hexlet.util.Cli;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
                0 - Exit
                Your choice:
                """);
        int n = scanner.nextInt();
        scanner.nextLine();
//
//
//        System.out.print("""
//                Welcome to the Brain Games!
//                May I have your name?
//                """);
//        String name = scanner.nextLine();
//        System.out.printf("Hello, %s! \n", name);

        switch (n) {
            case 1:
                Cli.welcomeUser();
                break;
            case 2:
                Even.run();
                break;
            case 3:
                Calc.run();
                break;
            case 4:
                new GCD().run();
                break;
            case 5:
                new Progression().run();
                break;
            case 6:
                new Prime().run();
                break;
            case 0:
                new Exit().run();
                break;
            default:
                System.out.println("Incorrect input!");
        }
    }

}
