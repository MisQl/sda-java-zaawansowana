package animals;

public abstract class Animal {              // nie możemy stworzyć instancji klasy abstrakcyjnej

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void saySomething();    // metoda abstrakcyjna nie posiada implementacji
}                                           // jeśli klasa bazowa nie będzie abstrakcyjna, będzie musiała ją zaimplementować
