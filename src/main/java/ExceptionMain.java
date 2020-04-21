import utils.StringHelper;

public class ExceptionMain {

    public static void main(String[] args) {
        System.out.println(StringHelper.parseToInt("1"));
        System.out.println(StringHelper.parseToInt("1a"));

        System.out.println();

        System.out.println(StringHelper.calculateSalary(100, 20));
        System.out.println(StringHelper.calculateSalary(100, -200));
    }
}
