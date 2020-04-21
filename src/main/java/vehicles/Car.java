package vehicles;

public class Car {

    private String brand;
    private String model;

    public Car(String brand, String model) {    // definiując własny konstruktor nie mamy już możliwościu użycia konstruktora domyślnego (generowany przez kompilator konstruktor bezargumentowy)
        this.brand = brand;
        this.model = model;
    }

    public void show() {
        System.out.println("To jest " + brand + " " + model);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
