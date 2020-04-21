import vehicles.Car;        // jeśli klasa jest zdefiniowana w innym pakiecie, to musimy ją zaimportować

public class VehiclesMain {

    public static void main(String[] args) {
        Car[] cars = new Car[5];
        cars[0] = new Car("BMW", "e46");
        cars[1] = new Car("Fiat", "Punto");
        cars[2] = new Car("Audi", "A6");
        cars[3] = new Car("Subaru", "Impreza WRX");
        cars[4] = new Car("Mercedes", "c63");

        Car thirdCar = cars[2];     // referencja thirdCar wskazuje na ten sam obiekt co cars[2]
        thirdCar.setModel("A7");

        for (Car car : cars) {
            car.show();
        }
    }
}
