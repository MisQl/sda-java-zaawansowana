package concurrency;

import java.util.concurrent.*;

public class FutureMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);

        Runnable runnable = () -> {                             // void run() - Runnable wymaga zaimplementowania metody
            sleep();
            System.out.println("Kończe pracę - runnable");
        };

        Callable<Integer> callable = () -> {                    // V call() throws Exception - Callable wymaga zaimplementowania metody
            System.out.println("Pracuje - callable");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Pracuje - callable");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Pracuje - callable");
            System.out.println("Kończe pracę - callable");
            return 1;                                           // Callable zwraca wartość
        };


        Future<Integer> resultFuture = executor.submit(callable);                   // Wynik jest opakowany w obiekt Future (w którym znajdzie się wynik pracy)

        System.out.println(resultFuture.isDone());                                  // false
        System.out.println("Czekam na wynik z Callable");
        Integer result = resultFuture.get();                                        // metoda blokująca - zatrzymanie obecnego wątku main w oczekiwaniu na zwrócenie wyniku przez Callable
        System.out.println(resultFuture.isDone());                                  // true
        System.out.println("Wynik: " + result);                                     // 1

        scheduledExecutor.scheduleAtFixedRate(runnable, 5, 2, TimeUnit.SECONDS);
    }

    private static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
