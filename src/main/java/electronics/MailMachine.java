package electronics;

public class MailMachine {

    private EmailSender[] senders = new EmailSender[3];

    public void addEmailSender(EmailSender emailSender) {
        for (int i = 0; i < senders.length; i++) {
            if (senders[i] == null) {
                senders[i] = emailSender;
                System.out.println("Dodaję nowe urządzenie");
                break;
            } else if (i == senders.length - 1) {
                System.out.println("Nie można dodać nowego urządzenia - maszyna jest pełna");
            }
        }
    }

    public void sendEmail(String message) {
        for (EmailSender emailSender : senders) {
            emailSender.sendEmail(message);
        }
    }
}
