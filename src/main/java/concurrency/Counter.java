package concurrency;

public class Counter {

    private int countOne = 0;
    private int countTwo = 0;

    public synchronized void incrementSafety() {    // tylko 1 wątek może wykonywać te operacje
        countOne = countOne + 1;

        if (countOne % 10_000 == 0) {
            System.out.println(countOne + " : " + Thread.currentThread().getName());
        }
    }

    public void increment() {                       // wszystkie wątki mogę wykonywać te poeracje, nawet w tym samym czasie
        countTwo = countTwo + 1;                    // występuje wyścig pomiędzy wątkami
    }

    public int getSafetyResult() {
        return countOne;
    }

    public int getResult() {
        return countTwo;
    }
}
