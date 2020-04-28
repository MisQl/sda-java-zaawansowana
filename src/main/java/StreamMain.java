import fruits.Apple;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMain {

    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple(3));
        apples.add(new Apple(5));
        apples.add(new Apple(2));
        apples.add(new Apple(2));
        apples.add(new Apple(6));
        apples.add(new Apple(7));

        apples.stream()                                         // tworzymy stream z elementami listy                   [A:3, A:5, A:2, A:2, A:6, A:6]
                .limit(5)                                       // tylko 5 pierwszych elementów                         [A:3, A:5, A:2, A:2, A:6]
                .skip(1)                                        // pomija 1 element                                     [A:5, A:2, A:2, A:6]
                .map(a -> a.getWeight())                        // Function - zamienia Apple -> Integer                 [5, 2, 2, 6]
                .distinct()                                     // usuwa duplikaty                                      [5, 2, 6]
                .filter(w -> w <= 5)                            // Predicate - pomija wartości nie spełniające warunku  [5, 2]
                .peek(w -> System.out.println(w))               // Consumer - wykonuje operacje i nie kończy Stream'a
                .sorted()                                       // sortuje obiekty Comparable (ClassCastException)      [2, 5]
                .forEach(a -> System.out.println("W:" + a));    // Consumer - kończy Stream

        // tworzenie
        System.out.println("\nTWORZENIE\n");

        Stream.of(1, 2, 3)                                      // stream elementów [1, 2, 3]
                .forEach(System.out::print);
        System.out.println();

        Stream.generate(() -> (int) (Math.random() * 100))      // stream nieskończonej ilości elementów
                .limit(10)                                      // ograniczenie do 10 elementów
                .forEach(System.out::print);
        System.out.println();

        Stream.iterate(0, n -> n + 1)                      // stream nieskończonej ilości elementów [0, 1, 2, 3...]
                .limit(10)                                      // ograniczenie do 10 elementów
                .forEach(System.out::print);
        System.out.println();

        Stream.iterate(0, n -> n < 4, n -> n + 1)          // stream elementów [0, 1, 2, 3]
                .forEach(System.out::print);
        System.out.println();

        // metody kończące

        boolean isAnyAppleHeavy = apples.stream()               // [A:3, A:5, A:2, A:2, A:6, A:7]
                .map(Apple::getWeight)                          // [3, 5, 2, 2, 6, 7]
                .anyMatch(w -> w > 5);                          // true - czy jakakolwiek element spełnia warunek

                // .allMatch(predicate) - czy każdy element spełnia warunek

        Optional<Integer> heavyApple = apples.stream()          // [A:3, A:5, A:2, A:2, A:6, A:7]
                .map(Apple::getWeight)                          // [3, 5, 2, 2, 6, 7]
                .filter(w -> w > 10)                            // []
                .findAny();                                     // pusty Optional - zwraca jakikolwiek element (zazwyczaj pierwszy) lub pusty Optional, jeśli nie ma elementów

                // .findFirst() - zwraca pierwszy element

        long count = apples.stream()                            // [A:3, A:5, A:2, A:2, A:6, A:7]
                .map(Apple::getWeight)                          // [3, 5, 2, 2, 6, 7]
                .filter(w -> w > 4)                             // [5, 6, 7]
                .count();                                       // 3 - ilość elementów

        // grupowanie
        System.out.println("\nGRUPOWANIE\n");

        List<Apple> heavyApples = apples.stream()
                .filter(a -> a.getWeight() > 4)
                .collect(Collectors.toList());                  // grupuje elementy w listę

        System.out.println("Ciężkie jabłka:");
        heavyApples.forEach(System.out::println);

        Map<Integer, String> appleBook = apples.stream()
                .filter(a -> a.getWeight() > 3)
                .collect(Collectors.toMap(a -> a.getWeight(), a -> a.toString()));      // grupuje jabłka do obiektu o interfejsie Map
                                                                                        // klucz wpisu jest tworzony wg. metody apple.getWeight()
                                                                                        // wartość wpisu jest tworzona wg. metody apple.toString()
        System.out.print(appleBook);

        String resultString = Stream.of("A", "B", "C")
                .collect(Collectors.joining(","));                 // "A,B,C"

        Integer resultInteger = Stream.of(1, 2, 3)
                .collect(Collectors.reducing(0, (a, b) -> a + b));  // 6
    }
}
