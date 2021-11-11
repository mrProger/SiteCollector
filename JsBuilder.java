package sitebuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class JsBuilder {

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
                        if (input.endsWith(".js")) {
                            filesList.add(input);
                        }
                        else if (input.endsWith(".")) {
                            filesList.add(input + "js");
                        }
                        else if (input.endsWith(".j")) {
                            filesList.add(input + "s");
                        }
                        else {
                            filesList.add(input + ".js");
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
                if (input.endsWith(".js")) {
                    resultFileName = input;
                    break;
                }
                else if (input.endsWith(".")) {
                    resultFileName = input + "js";
                    break;
                }
                else if (input.endsWith(".j")) {
                    resultFileName = input + "s";
                    break;
                }
                else {
                    resultFileName = input + ".js";
                    break;
                }
            }
        }

        for (int i = 0; i < filesList.size(); i++) {
            BuilderSystem.readJsFile(filesList.get(i), i + 1, codes);
        }

        boolean build = BuilderSystem.buildJsFile(resultFileName, filesCount, codes);

        if (build) {
            System.out.println("JS файл успешно собран");
        }
        else {
            System.out.println("Во время сборки, что-то пошло не так");
        }

        System.out.println("Нажмите любую клавишу, чтобы продолжить...");

        scanner.nextLine();

        Main.toMenu();
    }  
}