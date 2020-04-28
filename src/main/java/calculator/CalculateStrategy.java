package calculator;

public interface CalculateStrategy<T extends Number> {
    T calculate(T firstArgument, T secondArgument);
}
