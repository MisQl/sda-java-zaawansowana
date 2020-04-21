package utils;

public class StringHelper {

    public static int parseToInt(String value) {
        int result;
        try {
            result = Integer.parseInt(value);                                       // kod, który może spowodować rzucenie wyjątku
        } catch (NumberFormatException e) {                                         // typ wyjątku, który zostanie obsłużony, jeśli wystąpi
            System.out.println("Nie udało się zamienić " + value + " na liczbę");
            return 0;
        } finally {
            System.out.println("Zamiana zakończona");                               // ten kod wykona się zawsze, nawet jak w bloku chatch jest return
        }

        System.out.println("Wszystko przeszło pomyślnie");                          // ten kod wykona się tylko jak nie wejdziemy do bloku catch
        return result;
    }

    public static String calculateSalary(int salary, int bonus) {
        int totalSalary = salary + bonus;
        if (totalSalary < 0) {
            throw new SalaryNegativeNumberException(totalSalary);                   // rzucamy wyjątkiem
        }

        return String.valueOf(salary + bonus);
    }
}
