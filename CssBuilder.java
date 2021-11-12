package sitebuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class CssBuilder {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> filesList = new ArrayList<>();
    static ArrayList<String>[] codes = new ArrayList[9999];
    static int filesCount = 0;
    static String resultFileName = "";

    public static void main() {
        for (int i = 0; i < codes.length; i++) {
            codes[i] = new ArrayList<>();
        }

        BuilderSystem.clearScreen();

        while (true) {
            System.out.print("Введите имя файла для сборки: ");
            String input = scanner.nextLine();

            if (!input.equals("")) {
                if (filesCount < 9999) {
                    if (!input.equals("0")) {
                        if (input.endsWith(".css")) {
                            filesList.add(input);
                        }
                        else if (input.endsWith(".")) {
                            filesList.add(input + "css");
                        }
                        else if (input.endsWith(".c")) {
                            filesList.add(input + "ss");
                        }
                        else if (input.endsWith(".cs")) {
                            filesList.add(input + "s");
                        }
                        else {
                            filesList.add(input + ".css");
                        }

                        filesCount++;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        while (true) {
            System.out.print("Введите имя итогового файла: ");
            String input = scanner.nextLine();

            if (!input.equals("")) {
                if (input.endsWith(".css")) {
                    resultFileName = input;
                    break;
                }
                else if (input.endsWith(".")) {
                    resultFileName = input + "css";
                    break;
                }
                else if (input.endsWith(".c")) {
                    resultFileName = input + "ss";
                    break;
                }
                else if (input.endsWith(".cs")) {
                    resultFileName = input + "s";
                    break;
                }
                else {
                    resultFileName = input + ".css";
                    break;
                }
            }
        }

        for (int i = 0; i < filesList.size(); i++) {
            BuilderSystem.readCssFile(filesList.get(i), i + 1, codes);
        }

        Boolean build = BuilderSystem.buildCssFile(resultFileName, filesCount, codes);

        if (build) {
            System.out.println("CSS Файл успешно собран");
        }
        else {
            System.out.println("Во время сборки, что-то пошло не так");
        }

        System.out.println("Нажмите любую клавишу, чтобы продолжить...");

        scanner.nextLine();

        Main.toMenu();
    } 
}