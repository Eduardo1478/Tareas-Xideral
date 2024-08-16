package semana1.Inyeccion;

public class EmailNotifier implements Notifier {

    @Override
    public void send(String message){
        System.out.println("Enviando Correo: " + message);
    }
}
