package semana2.FunctionalInterfaces.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        
        //Case1: Using UnaryOperator interface to make a string into all Uppercase
        MyUnaryOperator<String> toUpperCaseUnitaryOperator = s -> s.toUpperCase();
        String result1 = toUpperCaseUnitaryOperator.apply("hello world");
        System.out.println("Lowercase to Uppercase: " + result1);

        //Case2: Using UnaryOperator interface to increment a number by 1
        MyUnaryOperator<Integer> incrementUnitaryOperator = x -> x + 1;
        Integer result2 = incrementUnitaryOperator.apply(7);
        System.out.println("Increment of 7: " + result2);

        //Case3: Using UnaryOperator interface to change the value of a boolean
        MyUnaryOperator<Boolean> negateUnitaryOperator = b -> !b;
        Boolean result3 = negateUnitaryOperator.apply(true);
        System.out.println("Negation of true: " + result3);

        //Case4: Using UnaryOperator interface to reverse a string
        MyUnaryOperator<String> reverseStringUnitaryOperator = s -> new StringBuilder(s).reverse().toString();
        String result4 = reverseStringUnitaryOperator.apply("hello");
        System.out.println("Reversed string of hello: " + result4);

    }
}
