package semana2.FunctionalInterfaces.Predicate;

public class Main {

    public static void main(String[] args) {

        //Case1: Using predicate interface to see if a number is even   
        MyPredicate<Integer> isEvenPredicate = num -> num % 2 == 0;
        System.out.println("Is 5 even: " + isEvenPredicate.test(5));

        //Case2: Using predicate interface to see if a number is null
        MyPredicate<Integer> isNullPredicate = num -> num == null;
        Integer nullValue = null;
        System.out.println("The value is null: " + isNullPredicate.test(nullValue));

        //Case3: Using predicate interface to see if a number is negative
        MyPredicate<Integer> isNegativePredicate = num -> num < 0;
        System.out.println("The value " + -8 + " is negative: " + isNegativePredicate.test(-8));

        //Case4: Using predicate interface to see if a word starts with E
        MyPredicate<String> startsWithEPredicate = word -> word.startsWith("E");
        System.out.println("Does \"Eduardo\" start with E? " + startsWithEPredicate.test("Eduardo")); // Output: true





    }



}
