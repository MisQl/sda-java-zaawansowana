package fruits;

public class Box<T extends WeightProvider> implements WeightProvider {

    private T content;

    public Box(T content) {                     // typ generyczny może przyjmować obiekty kalsy WeightProvider i wszystkich klas dziedziczących / implementujących
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    @Override
    public int getWeight() {
        return content.getWeight() + 1;         // dzięki ograniczeniu typu generycznego do WeightProvider
    }                                           // możemy wywołać metody z WeightProvider
}
