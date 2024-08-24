package semana2.FunctionalInterfaces.BiPredicate;

import semana2.FunctionalInterfaces.Predicate.MyPredicate;

public class Main {

    public static void main(String[] args) {

    //Case1: Using Bipredicate interface to see if the sum of a numbers is even 
    MyBiPredicate<Integer, Integer> isSumBiPredicate = (x, y) -> (x + y) % 2 == 0;
    System.out.println("Is 44 + 77 even: " + isSumBiPredicate.test(44, 77));

    //Case2: Using Bipredicate interface to see if a given number is a factor of another given number
    MyBiPredicate<Integer, Integer> isFactorBiPredicate = (x, y) -> y % x == 0;
    System.out.println("Is 6 a factor of 36: " + isFactorBiPredicate.test(6, 36));

    //Case3: Using Bipredicate interface to see if the multiplication of two numbers is even
    MyBiPredicate<Integer, Integer> isMultEvenPredicate = (x, y) -> x*y % 2  == 0;
    System.out.println("Is 7 time 83 even: " + isMultEvenPredicate.test(7, 83));

    //Case4: Using Bipredicate interface to see if the substraction of two numbers is even 
    MyBiPredicate<Integer, Integer> isSubBiPredicate = (x, y) -> (x - y) % 2 == 0;
    System.out.println("Is 44 - 77 even: " + isSubBiPredicate.test(44, 77));

    }
}
