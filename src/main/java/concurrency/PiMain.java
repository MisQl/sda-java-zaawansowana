package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.stream.IntStream;

public class PiMain {

    public static void main(String[] args) throws InterruptedException {
        long start, stop;
        double result;

        start = System.currentTimeMillis();
        result = calculate(1, 10_000_00000);
        stop = System.currentTimeMillis();
        System.out.println("Wynik: " + result);
        System.out.println("Przetwarzanie na 1 wątku zajeło: " + (stop - start));

        ExecutorService executor = Executors.newFixedThreadPool(4);
        DoubleAdder adder = new DoubleAdder();

        start = System.currentTimeMillis();
        executor.submit(() -> adder.add(calculate(1, 2_500_00000)));
        executor.submit(() -> adder.add(calculate(2_500_00001, 5_000_00000)));
        executor.submit(() -> adder.add(calculate(5_000_00001, 7_500_00000)));
        executor.submit(() -> adder.add(calculate(7_500_00001, 10_000_00000)));
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        result = adder.sum();
        stop = System.currentTimeMillis();

        System.out.println("Wynik: " + result);
        System.out.println("Przetwarzanie na 4 wątkach zajeło: " + (stop - start));
    }

    private static double calculate(int first, int last) {
        return IntStream.rangeClosed(first, last)
                .mapToDouble(i -> 4 * Math.pow(-1, i - 1) / (2 * i - 1))
                .sum();
    }
}
