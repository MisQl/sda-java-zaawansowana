package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SynchronizedMain {

    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            IntStream.range(0, 30_000).forEach(i -> {
                counter.increment();
                counter.incrementSafety();
            });
        };

        ExecutorService executor = Executors.newFixedThreadPool(4);
        executor.submit(runnable);                                              // przekazanie Runnable do kolejnego wątku
        executor.submit(runnable);                                              // przekazanie Runnable do kolejnego wątku
        executor.submit(runnable);                                              // przekazanie Runnable do kolejnego wątku
        executor.submit(runnable);                                              // przekazanie Runnable do kolejnego wątku

        executor.shutdown();                                                    // inicjalizacja zamknięcia puli wątków
        executor.awaitTermination(10, TimeUnit.SECONDS);                        // metoda blokująca - zatrzymanie obecnego wątku main w oczekiwaniu na zwrócenie wyników przez wszystkie Runnable

        System.out.println("Wynik: " + counter.getResult());
        System.out.println("Wynik z metody z zabezpieczeniem: " + counter.getSafetyResult());
    }
}
