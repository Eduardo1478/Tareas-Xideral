package semana1.Inyeccion;

public class NotificationService {

    private Notifier notifier;

    //Constructor de notifier
    public NotificationService(Notifier notifier){
        this.notifier = notifier;
    }
    //Metodo para enviar notificaciones
    public void notify(String message) {
        notifier.send(message);
    }
    
    
}
