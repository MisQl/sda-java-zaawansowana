package concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadMain {

    public static void main(String[] args) {

        Runnable runnableOne = () -> {                                          // void run() - Runnable wymaga zaimplementowania metody
            String threadName = Thread.currentThread().getName();
            System.out.println("Nazwa wątku: " + threadName);
            while (!Thread.interrupted()) {                                     // sprawdzamy, czy praca wątku nie została przerwana
                // work work work
            }
            System.out.println("Kończę pracę: " + threadName);
        };

        Runnable runnableTwo = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Nazwa wątku: " + threadName);

            try {
                TimeUnit.SECONDS.sleep(10);                                     // w przypadku przerwania podczas uśpienia rzucany jest wyjątek InterruptedException
            } catch (InterruptedException e) {
                System.out.println("Praca została przerwana: " + threadName);
            }

            System.out.println("Kończę pracę: " + threadName);
        };

        Thread threadOne = new Thread(runnableOne);
        Thread threadTwo = new Thread(runnableTwo);

        threadOne.start();
        threadOne.interrupt();      // żądanie przerwania pracy - ustawia flagę 'interrupted' wątku na true

        threadTwo.start();
        threadTwo.interrupt();
    }
}
