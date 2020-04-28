import fruits.Apple;
import fruits.Fruit;
import fruits.WeightProvider;

import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {
        method(new Apple(10));
        method(null);
        method(new Apple(4));
    }

    private static void method(Fruit fruit) {
        Optional<Fruit> fruitOptional = Optional.ofNullable(fruit);                  // tworzymy obiekt Optional
        Optional<Integer> weightOptional = fruitOptional.map(f -> f.getWeight());    // wykonujemy operację na ewentualnej zawartości obiektu Optional
        Integer weight = weightOptional.orElse(0);                             // wywołujemy metodę kończącą, która zwraca zawartość lub dostarcza 0 jeśli Optional jest pusty

        System.out.println("Waga: " + weight);

        Optional.ofNullable(fruit)                              // tworzymy obiekt Optional
                .map(WeightProvider::getWeight)                 // wywołujemy na nim metodę map(...) i otrzymujemy Optional<Integer>
                .filter(w -> w > 5)                             // jeśli warunek nie zostanie spełniony zwórcony Optional<Integer> będzie pusty
                .map(w -> w + 0.5)                              // wywołujemy na nim metodę map(...) i otrzymujemy Optional<Integer>
                .map(w -> "Owoc z opakowaniem waży: " + w)      // wywołujemy na nim metodę map(...) i otrzymujemy Optional<String>
                .ifPresent(w -> System.out.println(w));         // jeśli Optional nie jest pusty to przekazuje zawartość jako argument metody println
    }
}
