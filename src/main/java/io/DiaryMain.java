package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DiaryMain {

    public static void main(String[] args) {
        try {
            Path diaryPath = Paths.get("C:/dev/diary");
            Files.createDirectories(diaryPath);
            Scanner scanner = new Scanner(System.in);
            int value = processMenu(scanner);
            if (value == 1) {
                addEntry(diaryPath, scanner);
            } else {
                readEntry(diaryPath, scanner);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Wystąpił nieoczekiwany błąd: " + e.getMessage());
        }
    }

    private static int processMenu(Scanner scanner) {
        System.out.println("Co chcesz zrobić");
        System.out.println("1\tDodać wpis");
        System.out.println("2\tOdczytać wpis");

        int value = 0;
        while (value < 1 || value > 2) {
            System.out.println("Wybierz opcję: ");
            try {
                value = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawny format.");
                scanner.next();                                     // pobieramy niepoprawną wartość, która została wprowadzona
            }
        }

        return value;
    }

    private static void addEntry(Path diaryPath, Scanner scanner) {
        System.out.println("Podaj tytuł wpisu: ");
        String title = scanner.next();
        System.out.println("Podaj treść wpisu: ");
        String content = scanner.next();
        try {
            String fileName = title + ".txt";
            Path filePath = diaryPath.resolve(fileName);
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            PrintWriter printWriter = new PrintWriter(filePath.toFile());
            printWriter.println(content);
            printWriter.close();
        } catch (IOException e) {
            System.out.println("Nie udało się dodać wpisu: " + e.getMessage());
        }
    }

    private static void readEntry(Path diaryPath, Scanner scanner) throws IOException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Map<Integer, Path> diaryEntries = Files.list(diaryPath)
                .collect(Collectors.toMap(path -> atomicInteger.incrementAndGet(), path -> path));

        diaryEntries.entrySet().stream()
                .map(e -> String.format("%s\t%s", e.getKey(), e.getValue().getFileName().toString().replace(".txt", "")))
                .forEach(System.out::println);

        int value = 0;
        while (!diaryEntries.containsKey(value)) {
            System.out.println("Który wpis chcesz odczytać:");
            try {
                value = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Niepoprawny format.");
                scanner.next();                                     // pobieramy niepoprawną wartość, która została wprowadzona
            }
        }

        Path filePath = diaryPath.resolve(diaryEntries.get(value));
        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath)) {
            String content = bufferedReader.lines().reduce("", String::concat);
            System.out.println("Treść wpisu: " + content);
        } catch (IOException e) {
            System.out.println("Nie udało się odczytać wpisu: " + e.getMessage());
        }
    }
}
