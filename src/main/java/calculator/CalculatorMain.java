package calculator;

import java.util.List;

public class CalculatorMain {

    public static void main(String[] args) {
        Calculator<Integer> calculator = new Calculator<>();

        calculator.setFirstArgument(3);
        calculator.setSecondArgument(20);

        Integer resultOne = calculator.calculate((a, b) -> a + b);
        Integer resultTwo = calculator.calculate((a, b) -> a - b);
        Integer resultThree = calculator.calculate((a, b) -> a * b);
        Integer resultFour = calculator.calculate((a, b) -> a / b);

        System.out.println(List.of(resultOne, resultTwo, resultThree, resultFour));

        calculator.setFirstArgument(null);
        calculator.calculate((a, b) -> a % b);
    }
}
