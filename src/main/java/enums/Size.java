package enums;

public enum Size {

    SMALL, MEDIUM(10), BIG(15);                 // każda z wartości musi wywołać dowolny konstruktor

    int maxWeight;

    Size() {
        System.out.println("Wywołuję konstruktor bezargumentowy");
    }

    Size(int maxWeight) {
        this.maxWeight = maxWeight;
        System.out.println("Wywołuję konstruktor z argumentem " + maxWeight);
    }

    public int getMaxWeight() {
        return maxWeight;
    }
}
