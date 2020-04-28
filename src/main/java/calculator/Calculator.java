package calculator;

import java.util.Optional;

public class Calculator<T extends Number> {

    private Optional<T> firstArgument;
    private Optional<T> secondArgument;

    public T calculate(CalculateStrategy<T> strategy) {
        T first = firstArgument.orElseThrow(EmptyCalculationArgumentException::new);
        T second = secondArgument.orElseThrow(EmptyCalculationArgumentException::new);

        return strategy.calculate(first, second);
    }

    public void setFirstArgument(T firstArgument) {
        this.firstArgument = Optional.ofNullable(firstArgument);
    }

    public void setSecondArgument(T secondArgument) {
        this.secondArgument = Optional.ofNullable(secondArgument);
    }
}
