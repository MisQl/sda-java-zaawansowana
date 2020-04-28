package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ExecutorMain {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable runnable = () -> {
            IntStream.range(0, 10).forEach(i -> {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                sleep();
            });
        };

        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);

        executor.shutdown();            // inicjuje zamknięcie puli wątków
    }                                   // jeśli nie zostanie wywołane, po zakończeniu main i zleconych zadań, pula wątków będzie czekała w gotowości na nowe zadania

    private static void sleep() {
        try {
            TimeUnit.MILLISECONDS.sleep((int) (Math.random() * 900 + 100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
