package semana2.FunctionalInterfaces.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        // Case 1: Using MyBinaryOperator interface to concatenate two strings and convert the result to uppercase
        MyBinaryOperator<String> toUpperCaseAndConcat = (s1, s2) -> (s1 + s2).toUpperCase();
        String result1 = toUpperCaseAndConcat.apply("hello", " world");
        System.out.println("Concatenated and Uppercase: " + result1);

        // Case 2: Using MyBinaryOperator interface to add two numbers
        MyBinaryOperator<Integer> addNumbers = (x, y) -> x + y;
        Integer result2 = addNumbers.apply(7, 3);
        System.out.println("Sum of 7 and 3: " + result2);

        // Case 3: Using MyBinaryOperator interface to perform logical AND of two boolean values
        MyBinaryOperator<Boolean> logicalAnd = (b1, b2) -> b1 && b2;
        Boolean result3 = logicalAnd.apply(true, false);
        System.out.println("Logical AND of true and false: " + result3);

        // Case 4: Using MyBinaryOperator interface to concatenate two strings and reverse the result
        MyBinaryOperator<String> reverseAndConcat = (s1, s2) -> new StringBuilder(s1 + s2).reverse().toString();
        String result4 = reverseAndConcat.apply("hello", "world");
        System.out.println("Reversed concatenation of 'hello' and 'world': " + result4);
    }
}
