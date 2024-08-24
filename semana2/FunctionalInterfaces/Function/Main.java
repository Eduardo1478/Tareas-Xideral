package semana2.FunctionalInterfaces.Function;

import semana2.FunctionalInterfaces.BiPredicate.MyBiPredicate;

public class Main {

    public static void main(String[] args) {
        
    //Case1: Using Function interface to transform int to string
    MyFunction<Integer, String> intToStringFunction = x -> x.toString();
    String result = intToStringFunction.apply(15);
    System.out.println("Converted to string: " + result);

    //Case2: Using Function interface to transform int to binary
    MyFunction<Integer, String> intToBinaryFunction = x -> Integer.toBinaryString(x);
    System.out.println("15 in binary is: " + intToBinaryFunction.apply(15));

    //Case3: Using Function interface to transform celsius to farenheit
    MyFunction<Integer, Double> celsiusToFarenheitFunction = x -> (9.0/5.0)*x + 32;
    System.out.println("32 in celsius is " + celsiusToFarenheitFunction.apply(32) + " in farenheit");    

    //Case4: Using Function interface to transform farenheit to celsius
    MyFunction<Integer, Double> farenheitToCelsiusFunction = x -> (x-32) * 5.0/9.0;
    System.out.println("90 in farenheit is " + farenheitToCelsiusFunction.apply(90) + " in celsius");    





    }





}
