package ua.com.alevel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;

public class FileHelper {
    public FileHelper() {

    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String select;
        menu();
        while ((select = reader.readLine()) != null) {
            switch (select) {
                case "1" -> listFiles(reader);
                case "2" -> createFileOrFolder(reader);
                case "3" -> deleteFileOrFolder(reader);
                case "4" -> moveFileOrFolder(reader);
                case "5" -> searchFileOrFolder(reader);
                case "6" -> searchTextInAllFilesOrFolders(reader);
                case "7" -> exit();
                default -> System.out.println("Wrong Input! Try again!");
            }
        }
    }

    private void menu() {
        System.out.println();
        System.out.println("1. View all files and folders");
        System.out.println("2. Create file or folder in  directory");
        System.out.println("3. Delete file or folder in  directory");
        System.out.println("4. Move file or folder from directory to another directory");
        System.out.println("5. Search file or folder in  directory");
        System.out.println("6. Search text in all files and folders in  directory");
        System.out.println("7. Exit");
        System.out.println();
    }
    private void listFiles(BufferedReader reader) {
        try {
            System.out.println("Enter path to directory:");
            File directory = new File(reader.readLine());
            for (File file : directory.listFiles()) {
                System.out.println(file.getName());
            }
            menu();
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
            menu();
        }
    }

    private void createFileOrFolder(BufferedReader reader) {
        try {
            System.out.println("Enter path to directory:");
            File directory = new File(reader.readLine());
            System.out.println("1. Create file");
            System.out.println("2. Create folder");
            String choice = reader.readLine();
            System.out.println("Enter the name of the file or folder you want to create:");
            File file = new File(directory, reader.readLine());
            switch (choice) {
                case "1" -> file.createNewFile();
                case "2" -> file.mkdirs();
            }
            menu();
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
            menu();
        }
    }

    private void deleteFileOrFolder(BufferedReader reader) {
        try {
            System.out.println("Enter path to directory:");
            File directory = new File(reader.readLine());
            System.out.println("Enter file or folder to delete");
            File file = new File(directory, reader.readLine());
            recursiveDelete(file);
            menu();
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
            menu();
        }
    }

    private static void recursiveDelete(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                recursiveDelete(f);
            }
        }
        file.delete();
        System.out.println("Removed file or folder: " + file.getAbsolutePath());
    }

    private void moveFileOrFolder(BufferedReader reader) {
        try {
            System.out.println("Enter path to directory:");
            File directory = new File(reader.readLine());
            System.out.println("Enter file or folder to move");
            File file = new File(directory, reader.readLine());
            System.out.println("Enter path to directory where you wan to move the file ot directory");
            File newDirectory = new File(reader.readLine());
            file.renameTo(new File(newDirectory, file.getName()));
            menu();
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
            menu();
        }
    }

    private void searchFileOrFolder(BufferedReader reader) throws IOException {
        System.out.println("Enter path to directory:");
        String directory = reader.readLine();
        System.out.println("Enter a file or folder:");
        String file = reader.readLine();
        searchFileOrFolder(new File(directory), file);
        menu();
    }

    private static void searchFileOrFolder(File directory, String searchTerm) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().equalsIgnoreCase(searchTerm)) {
                        System.out.println(file.getAbsolutePath());
                    }else {
                        searchFileOrFolder(file, searchTerm);
                    }
                }
            }
        }
    }

    private void searchTextInAllFilesOrFolders(BufferedReader reader) {
        try {
            System.out.println("Enter path to directory:");
            File directory = new File(reader.readLine());
            System.out.println("Enter the text which you want to find");
            String term = reader.readLine().toLowerCase();
            searchFiles(directory, term);
            menu();
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
            menu();
        }
    }

    private static void searchFiles(File file, String searchTerm) {
        try {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File subfile : files) {
                        searchFiles(subfile, searchTerm);
                    }
                }
            } else {
                if (file.getName().toLowerCase().endsWith(".txt")) {
                    String content = Files.readString(file.toPath()).toLowerCase();
                    if (content.contains(searchTerm)) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Try again.");
        }
    }

    private void exit() {
        System.exit(0);
    }
}
