package electronics;

public class Radio extends Device {

    public Radio(String model) {
        super(model);
    }

    public void changeChannel(String channel) {
        System.out.println("Zmieniam kanał na " + channel);
    }

    @Override
    public void turnOn() {
        System.out.println("Radio " + model + " zaczyna grać");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio " + model + " przestaje grać");
    }
}
