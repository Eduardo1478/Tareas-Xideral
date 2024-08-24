package semana2.FunctionalInterfaces.Consumer;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Case1: Using consumer interface to read a message inserted by user and display it
        MyConsumer<String> messageConsumer = message -> System.out.println("Message: " + message);
        System.out.print("Enter message: ");
        String userInput = scanner.next();
        messageConsumer.accept(userInput);

        //Case2: Using consumer interface to raise to the power of 2 a number
        Integer number = 7;
        MyConsumer<Integer> powerConsumer = num -> System.out.println(num + " to the power of 2 = " + num*num);
        powerConsumer.accept(number);

        //Case3: Using consumer interface to get the square root of a number
        number = 81;
        MyConsumer<Integer> squareRootConsumer = num -> System.out.println(num + " to the square root of 2 = " + Math.sqrt(num));
        squareRootConsumer.accept(number);

        //Case4: Using consumer interface to read a name and greet that person
        MyConsumer<String> welcomeConsumer = message -> System.out.println("Welcome back " + message);
        System.out.print("Enter your name: ");
        String nameInput = scanner.next();
        welcomeConsumer .accept(nameInput);
        scanner.close();

    }

}
