package semana1.Singleton;

public class Logger {

    // se declara una instancia que es estatica y volatil
    private static volatile Logger instance;

    private Logger(){}

    // se lleva a cabo una doble verificacion para ver si instance es null
    public static Logger getInstance(){
        if(instance == null){
            synchronized(Logger.class){
                if(instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    // se imprime el mensaje
    public void log(String message){
        System.out.println("log: " + message);
    }
}
