package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VolatileMain {

    private static volatile boolean isDone = false;         // bez 'volatile' runnableOne nigdy nie zakończy pracy

    public static void main(String[] args) {
        Runnable runnableOne = () -> {
            while (!isDone) {
                // work work work
            }
            System.out.println("RunnableOne - Zakończyłem pracę");
        };

        Runnable runnableTwo = () -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isDone = true;
            System.out.println("RunnableTwo - Flaga zmieniona!");
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(runnableOne);
        executor.submit(runnableTwo);
        executor.shutdown();
    }
}
