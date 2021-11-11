package sitebuilder;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        toMenu();
    }

    public static void toMenu() {
        BuilderSystem.clearScreen();

        System.out.println("1) Js Сборщик");
        System.out.println("2) Css Сборщик");
        System.out.println("3) Sass Сборщик");
        System.out.println("4) Scss Сборщик");

        System.out.print("\n> ");
        String input = scanner.nextLine();

        if (input.equals("1")) {
            JsBuilder.main();
        }
        else if (input.equals("2")) {
            CssBuilder.main();
        }
        else if (input.equals("3")) {
            SassBuilder.main();
        }
        else if (input.equals("4")) {
            ScssBuilder.main();
        }
        else {
            toMenu();
        }
    }
}