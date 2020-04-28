package calculator;

public class EmptyCalculationArgumentException extends RuntimeException {

    public EmptyCalculationArgumentException() {
        super("Brakuje argumentu, żeby wykonać obliczenie");
    }
}
