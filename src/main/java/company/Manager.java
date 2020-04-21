package company;

public class Manager extends Employee {

    private int bonus;
    private Secretary secretary;

    public Manager(String name, int salary) {   // w klasie Employee nie ma konstruktora bezargumentowego, więc
        super(name, salary);                    // musimy wywołać inny konstruktor wykorzystując super(...)
        System.out.println("Wywołuję konstruktor klasy Manager z argumentami: " + name + " i " + salary);
    }

    public Manager(String name, int salary, int bonus) {
        super(name, salary);
        this.bonus = bonus;
        System.out.println("Wywołuję konstruktor klasy Manager z argumentami: " + name + ", " + salary + " i " + bonus);
    }

    public void makeSpeech() {
        System.out.println("Do pracy!");
    }

    public void makeSpeech(String additionalMessage) {      // przeciążona metoda jest wywołana, jeśli podamy dodatkowy argument
        System.out.print(additionalMessage);
    }

    @Override
    public void show() {                            // przesłonięta metoda podmienia zachowanie metody z klasy bazowej Manager
        super.show();                               // super.show() powoduje wywołanie metody show() z klasy bazowej
        System.out.println("Jestem managerem!");
    }

    public void makeCall(String number) {
        if (secretary == null) {
            System.out.println("Nie mam telefonu!");
        } else {
            System.out.println("Moja sekretarka zadzwoni");
            secretary.makeCall(number);                         // delegacja do obiektu klasy Secretary
        }
    }

    @Override
    public int getSalary() {
        return salary + bonus;                      // pole salary pochodzi z klasy bazowej
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }
}

//    Przydatny skrót IntelliJ Idea - [CTRL + B] kursor musi znajdować się na polu lub metodzie
