package semana2.FunctionalInterfaces.BiConsumer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import semana2.FunctionalInterfaces.Consumer.MyConsumer;


public class Main {
    public static void main(String[] args) {


        //Case1: Using Biconsumer interface to add two numbers
        MyBiConsumer<Integer, Integer> additionBiCosnumer = (x, y) -> System.out.println(x + " + " + y + " = " + (x+y));
        additionBiCosnumer.accept(67, 33);

        //Case2: Using Biconsumer interface to get the date and time and display them
        MyBiConsumer<LocalDate, LocalTime> dateTimeBiCosnumer = (x, y) -> System.out.println("Date: " + x + "   Time: " + y);
        dateTimeBiCosnumer.accept(LocalDate.now(), LocalTime.now());

        //Case3: Using Biconsumer interface to get the first name and last name of a person and display it
        Scanner scanner = new Scanner(System.in);
        MyBiConsumer<String, String> fullNameBiConsumer = (fname, lname) -> System.out.println("First name: " + fname + "   Last name: " + lname);
        System.out.print("Enter first name: ");
        String fname = scanner.next();
        System.out.print("Enter last name: ");
        String lname = scanner.next();
        fullNameBiConsumer.accept(fname, lname);
        scanner.close();

        //Case2: Using Biconsumer interface to subtract two numbers
        MyBiConsumer<Integer, Integer> substractionBiCosnumer = (x, y) -> System.out.println(x + " + " + y + " = " + (x-y));
        substractionBiCosnumer.accept(67, 33);



    }
}

