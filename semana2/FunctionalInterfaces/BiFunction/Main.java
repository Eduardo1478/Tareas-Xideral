package semana2.FunctionalInterfaces.BiFunction;

import semana2.FunctionalInterfaces.Function.MyFunction;

public class Main {

    public static void main(String[] args) {
                
    //Case1: Using BiFunction interface to make the sum of the numbers into a string
    MyBiFunction<Integer, Integer, String> sumToStringBiFunction = (x, y) -> Integer.toString(x+y);
    String result = sumToStringBiFunction.apply(15, 9);
    System.out.println("Addition made to string: " + result);

    //Case2: Using BiFunction interface to add two numbers and get the binary result
    MyBiFunction<Integer, Integer, String> sumToBinaryBiFunction = (x, y) -> Integer.toBinaryString(x + y);
    System.out.println("The sum of 15 and 9 in binary is: " + sumToBinaryBiFunction.apply(15, 9));

    //Case3: Using BIFunction interface to raise to the power of two the sum of two numbers
    MyBiFunction<Integer, Integer, Integer> powerOfSumBiFunction = (x, y) -> (x + y)*(x + y);
    System.out.println("The power of two of the sum of 7 and 9 is: " + powerOfSumBiFunction.apply(7, 9));  

    //Case4: Using BiFunction interface to make two digits into a number
    MyBiFunction<Integer, Integer, Integer> digitsToNumberBiFunction = (x, y) -> x*10 + y;
    System.out.println("The digits 7 and 9 make: " + digitsToNumberBiFunction.apply(7, 9));  

    }

}
