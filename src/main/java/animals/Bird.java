package animals;

public abstract class Bird extends Animal {     // Bird nie musi implementować abstrakcyjnych metod z klasy Animal bo też jest klasą abstrakcyjną

    public Bird(String name) {
        super(name);
    }
}
