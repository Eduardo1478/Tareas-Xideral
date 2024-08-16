package semana1.Inyeccion;

public class SMSNotifier implements Notifier {

    @Override
    public void send(String message){
        System.out.println("Enviando SMS: " + message);
    }
}
