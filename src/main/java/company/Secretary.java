package company;

public final class Secretary extends Employee {     // nie możemy dziedziczyć po klasie oznaczonej jako final

    public Secretary(String name, int salary) {
        super(name, salary);
        System.out.println("Wywołuję konstruktor klasy Secretary z argumentami: " + name + " i " + salary);
    }

    public void makeCall(String number) {
        System.out.println("Dzwonię do: " + number);
    }
}
