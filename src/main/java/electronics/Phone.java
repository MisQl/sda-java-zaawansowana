package electronics;

public class Phone extends Device implements EmailSender {

    private String number;

    public Phone(String model, String number) {
        super(model);
        this.number = number;
    }

    public void makeCall(String number) {
        System.out.println("Dzwonię do " + number);
    }

    @Override
    public void turnOn() {
        System.out.println("Podświetlasz ekran " + model);
    }

    @Override
    public void turnOff() {
        System.out.println("Ekran " + model + " gaśnie");
    }

    @Override
    public void sendEmail(String message) {
        System.out.println("Wysyłasz email z " + model + ": " + message);
    }
}
