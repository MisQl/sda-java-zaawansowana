package collections;

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException() {
        super("Kolejka jest pusta");
    }
}
