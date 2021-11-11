package sitebuilder;

import java.util.ArrayList;
import java.io.*;

public class BuilderSystem {
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean readJsFile(String fileName, int fileIndex, ArrayList<String>[] codes) {
        boolean status = false;

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                codes[fileIndex - 1].add(line);
                line = reader.readLine();
            }

            status = true;
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public static boolean buildJsFile(String resultFileName, int filesCount, ArrayList<String>[] codes) {
        boolean status = false;

        try(FileWriter writer = new FileWriter(resultFileName, false)) {
            for (int file = 0; file < filesCount; file++) {
                for (int i = 0; i < codes[file].size(); i++) {
                    writer.write(codes[file].get(i) + "\n");
                }
                writer.write("\n");
            }

            writer.flush();

            status = true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            status = false;
        }

        return status;
    }

    public static boolean readCssFile(String fileName, int fileIndex, ArrayList<String>[] codes) {
        boolean status = false;

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                codes[fileIndex - 1].add(line);
                line = reader.readLine();
            }

            status = true;
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public static boolean buildCssFile(String resultFileName, int filesCount, ArrayList<String>[] codes) {
        boolean status = false;

        try(FileWriter writer = new FileWriter(resultFileName, false)) {
            for (int file = 0; file < filesCount; file++) {
                for (int i = 0; i < codes[file].size(); i++) {
                    writer.write(codes[file].get(i) + "\n");
                }
                writer.write("\n");
            }
            
            writer.flush();

            status = true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            status = false;
        }

        return status;
    }

    public static boolean readSassFile(String fileName, int fileIndex, ArrayList<String>[] codes) {
        boolean status = false;

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                codes[fileIndex - 1].add(line);
                line = reader.readLine();
            }

            status = true;
            reader.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public static boolean buildSassFile(String resultFileName, int filesCount, ArrayList<String>[] codes) {
        boolean status = false;

        try(FileWriter writer = new FileWriter(resultFileName, false)) {
            for (int file = 0; file < filesCount; file++) {
                for (int i = 0; i < codes[file].size(); i++) {
                    writer.write(codes[file].get(i) + "\n");
                }
                writer.write("\n");
            }
            
            writer.flush();

            status = true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            status = false;
        }

        return status;
    }

    public static boolean readScssFile(String fileName, int fileIndex, ArrayList<String>[] codes) {
        boolean status;

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                codes[fileIndex - 1].add(line);
                line = reader.readLine();
            }

            status = true;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            status = false;
        }

        return status;
    }

    public static boolean buildScssFile(String resultFileName, int filesCount, ArrayList<String>[] codes) {
        boolean status;

        try(FileWriter writer = new FileWriter(resultFileName, false)) {
            for (int file = 0; file < filesCount; file++) {
                for (int i = 0; i < codes[file].size(); i++) {
                    writer.write(codes[file].get(i) + "\n");
                }
                writer.write("\n");
            }
            
            writer.flush();

            status = true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            status = false;
        }

        return status;
    }
}