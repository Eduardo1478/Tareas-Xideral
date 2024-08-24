package semana2.FunctionalInterfaces.Supplier;

import java.time.LocalDate;
import java.util.Random;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        //Case1: Using supplier interface to simulate a throw of a 6 sided dice
        MySupplier<Integer> diceSupplier = () -> new Random().nextInt(6) + 1;

        System.out.println("Dice throw: " + diceSupplier.get());


        //Case2: Using supplier to check if the IDs exist. In this case it gives an error because the ID is null
        MySupplier<String> errorSupplier = () -> "Error";
        Integer id = null;
        String errorCheck = (id == null) ? errorSupplier.get(): id.toString();

        System.out.println("ID: " + errorCheck);

        //In this case a valid ID is given
        id = 3;
        errorCheck = (id == null) ? errorSupplier.get(): id.toString();

        System.out.println("ID: " + errorCheck);


        //Case3: Using supplier interface to get the current date
        MySupplier<LocalDate> dateSupplier = () -> LocalDate.now();

        System.out.println("Current Date:  " + dateSupplier.get());


        //Case4: Using supplier interface to get the current time
        MySupplier<LocalTime> timeSupplier = () -> LocalTime.now();
    
        System.out.println("Current time:  " + timeSupplier.get());
        
    }
}
