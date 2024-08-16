package semana1.Singleton;

public class main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.log("Este es el primer mensaje");
        logger.log("Segundo mensaje");
    }
}
