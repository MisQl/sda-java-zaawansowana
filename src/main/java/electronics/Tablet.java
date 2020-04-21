package electronics;

public class Tablet extends Device implements EmailSender {

    public Tablet(String model) {
        super(model);
    }

    public void sendMessage(String type, String message) {
        String consoleMessage = String.format("Wysyłam wiadomość typu %s z %s: %s", type, model, message);      // każdy %s jest zastępowany wartością zmiennej
        System.out.println(consoleMessage);
    }

    @Override
    public void turnOn() {
        System.out.println("Tablet " + model + " zostaje włączony");
    }

    @Override
    public void turnOff() {
        System.out.println("Tablet " + model + " zostaje wyłączony");
    }

    @Override
    public void sendEmail(String message) {
        sendMessage("email", message);
    }
}
