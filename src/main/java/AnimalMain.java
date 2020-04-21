import animals.*;

public class AnimalMain {

    public static void main(String[] args) {
        Dog dog = new Dog("Ares");
        Cat cat = new Cat("Filemon");
        Duck duck = new Duck("Dziwaczka");

        Duck.Chick chick = duck.new Chick();        // tworzymy instancję klasy wewnętrznej Chick
        chick.say();                                // jeśli klasa wewnętrzna nie jest statyczna, to potrzebujemy obiektu klasy Duck

        Animal animal = duck;                       // referencja może mieć inny typ niż obiekt
        Bird bird = duck;                           // pod warunkiem, że jest wyżej w hierarchii dziedziczenia (klasa bazowa jest wyżej niż klasa potomna)

        Runner runnerOne = dog;                     // obiekt Dog może zostać przypisany do referencji typu Runner
        Runner runnerTwo = cat;

        runnerOne.count();                          // referencja typu Runner może wywołać tylko metody run() i count()
        runnerTwo.run();

        Animal snail = new Animal("Ślimak Romek") {     // klasa anonimowa musi zaimplementować wszystkie metody abstrakcyjne
            @Override
            public void saySomething() {
                System.out.println("Jestem ślimak " + name);    // klasa anonimowa ma dostęp do pól i metod jak zwykła klasa dziedzicząca po Animal
            }
        };

        snail.saySomething();
    }
}
