package sitebuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class ScssBuilder {
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
                        if (input.endsWith(".scss")) {
                            filesList.add(input);
                        }
                        else if (input.endsWith(".")) {
                            filesList.add(input + "scss");
                        }
                        else if (input.endsWith(".s")) {
                            filesList.add(input + "css");
                        }
                        else if (input.endsWith(".sc")) {
                            filesList.add(input + "ss");
                        }
                        else if (input.endsWith(".scs")) {
                            filesList.add(input + "s");
                        }
                        else {
                            filesList.add(input + ".scss");
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
                if (input.endsWith(".scss")) {
                    resultFileName = input;
                    break;
                }
                else if (input.endsWith(".")) {
                    resultFileName = input + "scss";
                    break;
                }
                else if (input.endsWith(".s")) {
                    resultFileName = input + "css";
                    break;
                }
                else if (input.endsWith(".sc")) {
                    resultFileName = input + "ss";
                    break;
                }
                else if (input.endsWith(".scs")) {
                    resultFileName = input + "s";
                    break;
                }
                else {
                    resultFileName = input + ".scss";
                    break;
                }
            }
        }

        for (int i = 0; i < filesList.size(); i++) {
            BuilderSystem.readScssFile(filesList.get(i), i + 1, codes);
        }

        boolean build = BuilderSystem.buildScssFile(resultFileName, filesCount, codes);

        if (build) {
            System.out.println("Scss Файл успешно собран");
        }
        else {
            System.out.println("Во время сборки, что-то пошло не так");
        }

        scanner.nextLine();

        Main.toMenu();
    }
}