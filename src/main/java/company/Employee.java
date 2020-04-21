package company;

public class Employee {

    private String name;
    protected int salary;       // modyfikator zasięgu protected zezwala na użycie pola salary w klasach pochodnych, nawet poza pakietem comapny

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        System.out.println("Wywołuję konstruktor klasy Employee z argumentami: " + name + " i " + salary);
    }

    public void show() {
        System.out.println("Mam na imię " + name + " i zarabiam " + salary);
    }

    public int getSalary() {
        return salary;
    }
}
