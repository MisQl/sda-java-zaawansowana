package concurrency;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MapMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> safetyMap = new ConcurrentHashMap<>();

        Runnable runnable = () -> {
            Random random = new Random();

            IntStream.range(0, 10_000).forEach(i -> {
                safetyMap.compute(random.nextInt(100), (k, v) -> v == null ? 1 : v + 1);
            });
            IntStream.range(0, 10_000).forEach(i -> {
                map.compute(random.nextInt(100), (k, v) -> v == null ? 1 : v + 1);
            });
        };

        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.submit(runnable);
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println(safetyMap);
        safetyMap.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(e -> "Najczęściej generowana liczba to " + e.getKey() + " - " + e.getValue() + " razy")
                .ifPresent(System.out::println);

        map.values().stream().reduce(Integer::sum).ifPresent(r -> System.out.println("Suma kontrolna HashMap: " + r));
        safetyMap.values().stream().reduce(Integer::sum).ifPresent(r -> System.out.println("Suma kontrolna ConcurrentHashMap: " + r));
    }
}
