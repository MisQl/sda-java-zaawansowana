package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExercisesMain {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("");          // jesli nie podamy wartości, to domyślą ścieżką będzie scieżka do projektu

        System.out.println("");

        Files.walk(path)
                .filter(p -> p.getFileName().toString().contains("Main"))
                .forEach(System.out::println);

        System.out.println("");

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Podaj swoje imie: ");
            String name = scanner.next();
            System.out.println("Podaj rok swojego urodzenia: ");
            int birthYear = scanner.nextInt();
            System.out.println("Podaj miesiąc swojego urodzenia: ");
            int birthMonth = scanner.nextInt();
            System.out.println("Podaj dzień swojego urodzenia: ");
            int birthDay = scanner.nextInt();

            LocalDate birthDate = LocalDate.of(birthYear, birthMonth, birthDay);
            int age = Period.between(birthDate, LocalDate.now()).getYears();
            String isLegalOfAge = age < 18 ? "nie jesteś" : "jesteś";
            System.out.println(String.format("Witaj %s, masz %s lat i %s pełnoletni", name, age, isLegalOfAge));
        } catch (DateTimeException e) {
            System.out.println("Niepoprawna data urodzenia: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Wprowadzono niepoprawny format danych.");
        }

    }
}
