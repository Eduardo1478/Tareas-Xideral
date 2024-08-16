package semana1.Inyeccion;

public class main {

    public static void main(String[] args) {
        // Inyectar EmailNotifier 
        Notifier emailNotifier = new EmailNotifier();
        NotificationService emailService = new NotificationService(emailNotifier);
        emailService.notify("Este es un mensaje de correo electrónico.");
       
        // Inyectar SMSNotifier 
        Notifier smsNotifier = new SMSNotifier();
        NotificationService smsService = new NotificationService(smsNotifier);
        smsService.notify("Este es un mensaje SMS.");

    }
    
}
