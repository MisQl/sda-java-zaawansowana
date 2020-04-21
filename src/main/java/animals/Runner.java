package animals;

public interface Runner {

    void run();

    default void count() {                      // metoda default wymaga implementacji w interfejsie
        System.out.println("3, 2, 1...");       // jest dziedziczona przez klasy implementujące interfejs Runnable i może być przesłonięta

        run();                                  // wywołanie metody run() z klasy implementującej interfejs Runner
    }
}
