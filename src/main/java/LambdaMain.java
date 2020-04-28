import collections.Gender;
import collections.Person;
import fruits.Apple;
import fruits.Fruit;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.function.*;

public class LambdaMain {

    public static void main(String[] args) {

        Function<Integer, String> function = new Function<Integer, String>() {          // klasa anonimowa implementująca funkcjonalność interfejsu Function
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };

        Function<Integer, String> parseInteger = a -> String.valueOf(a);                // zapis równoważny z powwyższym, przy użyciu wyrażenia lambda
        String stringValue = parseInteger.apply(20);

        Predicate<Fruit> checkIsHeavy = f -> f.getWeight() > 10;                        // boolean test(Fruit t) - metoda do zaimplementowania
        boolean isHeavy = checkIsHeavy.test(new Apple(5));

        Consumer<Person> displayInformation = p -> System.out.println(p);               // void accept(Person t) - metoda do zaimplementowania
        displayInformation.accept(new Person("Jan", 20, Gender.MALE));

        Supplier<Integer> generateInteger = () -> (int) (Math.random() * 100);          // Integer get() - metoda do zaimplementowania
        Integer integer = generateInteger.get();

        // referencje do metod i konstruktorów

        Set<Integer> set = new HashSet<>();
        Consumer<Integer> consumerOne = i -> set.add(i);                                // referencja metody konkretnego obiektu
                                                                                        // argument wejściowy lambdy jest przekazywany do metody

        Supplier<LocalDate> supplierOne = () -> LocalDate.now();
        Supplier<LocalDate> supplierTwo = LocalDate::now;                               // referencja metody statycznej
                                                                                        // podobne do przypodku powyżej, stylko metoda jest statyczna

        Function<String, Integer> functionOne = s -> s.length();
        Function<String, Integer> functionTwo = String::length;                         // referencja metody, która jest wywoływana na obiekcie przekazywanym jako argument

        Function<Integer, Apple> functionThree = i -> new Apple(i);
        Function<Integer, Apple> functionFour = Apple::new;                             // referencja konstruktora

        // lambda przekazywana w argumencie metody

        calculate(Integer::sum);
        calculate((a, b) -> a - b);
        calculate((a, b) -> a * b);
        calculate((a, b) -> a / b);
    }

    public static void calculate(BinaryOperator<Integer> function) {
        int firstInteger = 10;
        int secondInteger = 4;
        Integer result = function.apply(firstInteger, secondInteger);                   // następuje wywołanie zaimplementowanej logiki, przekazanej w argumencie
        System.out.println("Wynik obliczeń: " + result);
    }
}
