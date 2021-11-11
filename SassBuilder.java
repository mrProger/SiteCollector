package sitebuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class SassBuilder {
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
                        if (input.endsWith(".sass")) {
                            filesList.add(input);
                        }
                        else if (input.endsWith(".")) {
                            filesList.add(input + "sass");
                        }
                        else if (input.endsWith(".s")) {
                            filesList.add(input + "ass");
                        }
                        else if (input.endsWith(".sa")) {
                            filesList.add(input + "ss");
                        }
                        else if (input.endsWith(".sas")) {
                            filesList.add(input + "s");
                        }
                        else {
                            filesList.add(input + ".sass");
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
                if (input.endsWith(".sass")) {
                    resultFileName = input;
                    break;
                }
                else if (input.endsWith(".")) {
                    resultFileName = input + "sass";
                    break;
                }
                else if (input.endsWith(".s")) {
                    resultFileName = input + "ass";
                    break;
                }
                else if (input.endsWith(".sa")) {
                    resultFileName = input + "ss";
                    break;
                }
                else if (input.endsWith(".sas")) {
                    resultFileName = input + "s";
                    break;
                }
                else {
                    resultFileName = input + ".sass";
                    break;
                }
            }
        }

        for (int i = 0; i < filesList.size(); i++) {
            BuilderSystem.readSassFile(filesList.get(i), i + 1, codes);
        }

        boolean build = BuilderSystem.buildSassFile(resultFileName, filesCount, codes);

        if (build) {
            System.out.println("Sass Файл успешно собран");
        }
        else {
            System.out.println("Во время сборки, что-то пошло не так");
        }

        scanner.nextLine();

        Main.toMenu();
    } 
}