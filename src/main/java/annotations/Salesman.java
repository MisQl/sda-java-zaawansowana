package annotations;

@Skills({"swimming", "singing"})
@Worker(suitColor = "white")
public class Salesman {

    private String name;
    private String email;

    public Salesman(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void sendMessage(String message) {
        System.out.println("Wysyłam z maila " + email + " wiadomość: " + message);
    }

    @Override
    public String toString() {
        return "Salesman{name=" + name + ", email=" + email + '}';
    }
}
